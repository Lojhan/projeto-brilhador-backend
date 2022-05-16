package com.apigateway.gateway;

import java.util.Map;

import com.apigateway.gateway.configuration.UriConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class GatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {

		System.out.println("\n");
		Builder routeBuilder = builder.routes();
		for (Map.Entry<String, String> entry : uriConfiguration.getUris().entrySet()) {
			String serviceName = entry.getKey();
			String serviceEndpoint = entry.getValue();
			String id = serviceName.toUpperCase();
			System.out.println(String.format("[SERVICE MAPPED] %s -> /%s/**", id, serviceName));
			routeBuilder.route(id, p -> createRoute(p, serviceName, serviceEndpoint));
		}
		System.out.println("\n");
		return routeBuilder.build();
	}

	Buildable<Route> createRoute(PredicateSpec p, String path, String service) {
		String url = String.format("/%s/**", path);
		return p.path(url).filters(r -> r.stripPrefix(1)
			.circuitBreaker(configConsumer -> configConsumer.setFallbackUri("forward:/fallback")))
		.uri(service); 
	}

	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}

}
