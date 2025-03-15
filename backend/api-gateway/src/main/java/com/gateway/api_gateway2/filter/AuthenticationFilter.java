package com.gateway.api_gateway2.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.gateway.api_gateway2.repository.UserRepository;
import com.gateway.api_gateway2.service.UserService;
import com.gateway.api_gateway2.util.JwtUtil;

import reactor.core.publisher.Mono;
@Component
public class AuthenticationFilter implements GlobalFilter{
	 	@Autowired
	    private RouteValidator validator;
	    @Autowired
	    private JwtUtil jwtUtil;
	    @Autowired
	    UserRepository userRepository; 
	    @Autowired
	    UserService userService;
		public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("****my filtering*****");
        	ServerHttpRequest request=null;
            if (validator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
                    jwtUtil.validateToken(authHeader);
                    String userName=jwtUtil.getUsernameFromToken(authHeader);
                    String id = userService.getIdByUsername(userName);
                    System.out.println(userName);
                    System.out.println(id);
                 request=  exchange.getRequest().mutate().
                		 header("loggedInUser", id).build();
 
                } catch (Exception e) {
                	e.printStackTrace();
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange.mutate().request(request).build());
	}
//	 @Override
//	    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//	        System.out.println("**** AuthenticationFilter triggered ****");
//
//	        // Check if the Authorization header is present for testing purposes
//	        HttpHeaders headers = exchange.getRequest().getHeaders();
//	        String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
//
//	        if (authHeader != null) {
//	            System.out.println("Authorization Header Present: " + authHeader);
//	            
//	            // For testing: Add a mock header to indicate the user is "logged in"
//	            ServerHttpRequest modifiedRequest = exchange.getRequest().mutate()
//	                    .header("loggedInUser", "test-user-id")
//	                    .build();
//
//	            // Proceed with the modified request
//	            return chain.filter(exchange.mutate().request(modifiedRequest).build());
//	        } else {
//	            System.out.println("No Authorization header present");
//	            // Proceed without modification if no Authorization header is found
//	            return chain.filter(exchange);
//	        }
//	    }
 
	
}
