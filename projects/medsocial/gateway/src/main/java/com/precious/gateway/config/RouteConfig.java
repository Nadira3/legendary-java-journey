package com.precious.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class RouteConfig {

    	@Bean
    	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
    	    		.route(r -> r
    	    				.path("/api/v1/auth/**")
    	    				.filters(f -> f.circuitBreaker(config -> config
    	    					.setName("authCmd")
    	    					.setFallbackUri("forward:/fallback/auth")))	
    	    				.uri("lb://auth-service"))
    	    		.route(r -> r
    	    				.path("/api/v1/users/**")
    	    				.filters(f -> f.circuitBreaker(config -> config
    	    					.setName("userCmd")
    	    					.setFallbackUri("forward:/fallback/users")))
    	    				.uri("lb://user-service"))
    	    		.build();
    	}
}
