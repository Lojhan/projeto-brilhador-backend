package com.apigateway.gateway.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Mono;

@Component
public class FallbackController {
    @RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}
}
