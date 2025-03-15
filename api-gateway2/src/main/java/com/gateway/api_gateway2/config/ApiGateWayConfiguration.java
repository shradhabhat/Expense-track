package com.gateway.api_gateway2.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateWayConfiguration {

	@Bean
	public RouteLocator gateWayRouter(RouteLocatorBuilder builder) {
		return builder.routes().
				//route(p->p.path("/feignclientForSecurityTest/**").uri("lb://restful-web-services")).
				route(p->p.path("/auth/**").uri("lb://identity-service2")).
				route(r->r.path("/users/**").uri("lb://restful-web-services")).
				route(r->r.path("/transaction/**").uri("lb://restful-web-services")).
				route(r->r.path("/budget/**").uri("lb://restful-web-services"))
				.build();
	}
}
