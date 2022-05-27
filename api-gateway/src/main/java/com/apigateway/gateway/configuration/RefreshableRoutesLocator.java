package com.apigateway.gateway.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.net.URISyntaxException;

@Component
public class RefreshableRoutesLocator implements RouteLocator {

    private final RouteLocatorBuilder builder;
    private final GatewayRoutesRefresher gatewayRoutesRefresher;

    private RouteLocatorBuilder.Builder routesBuilder;
    private Flux<Route> route = Flux.empty();

    @Autowired
    public RefreshableRoutesLocator(
        @NonNull final RouteLocatorBuilder builder,
        @NonNull final GatewayRoutesRefresher gatewayRoutesRefresher
    ) {
        this.builder = builder;
        this.gatewayRoutesRefresher = gatewayRoutesRefresher;
        clearRoutes();
    }

    public void clearRoutes() {
        routesBuilder = builder.routes();
    }

    @NonNull
    public RefreshableRoutesLocator addRoute(@NonNull final String id, @NonNull final String key, @NonNull final String value) throws URISyntaxException {
        routesBuilder.route(id, fn -> CreateRoute.createRoute(fn, key,value));
        return this;
    }

    public void buildRoutes() {
        this.route = routesBuilder.build().getRoutes();
        gatewayRoutesRefresher.refreshRoutes();
    }

    @Override
    public Flux<Route> getRoutes() {
        return route;
    }
}
