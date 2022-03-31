package com.apigateway.gateway;

import com.apigateway.gateway.configuration.UriConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class GatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
		return builder.routes()
				.route("AUTHENTICATION", p -> p
					.path("/auth/**")
					.filters(r -> r
						.stripPrefix(1)
						.circuitBreaker(configConsumer -> configConsumer.setFallbackUri("forward:/fallback")))
					.uri("http://authentication-service-brilhador")
				).build();
	}

	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}

}
