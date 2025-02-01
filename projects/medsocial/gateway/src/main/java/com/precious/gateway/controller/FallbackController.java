package com.precious.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/fallback/auth")
    public Mono<String> authFallback() {
	    return Mono.just("Auth service is taking longer than expected. Please try again later");
    }

    @GetMapping("/fallback/users")
    public Mono<String> userFallback() {
	    return Mono.just("User service is taking longer than expected. Please try again later");
    }

}
