package com.apigateway.gateway.configuration;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

public class CreateRoute {
    static Buildable<Route> createRoute(PredicateSpec p, String path, String service) {
		String url = String.format("/%s/**", path);
		return p.path(url).filters(r -> r.stripPrefix(1)
			// .circuitBreaker(configConsumer -> configConsumer.setFallbackUri("forward:/fallback"))
			)
		.uri(service); 
	}
}
