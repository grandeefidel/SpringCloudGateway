package com.cgGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SpringCloudConfig {

//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/fidelivery/**")
//                        //Pre and Post Filters provided by Spring Cloud Gateway
//                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")
//                                .addResponseHeader("first-response", "first-response-header"))
//                        .uri("http://localhost:8081/")
//                        .id("fideliveryModule"))
//
//                .route(r -> r.path("/api/**")
//                        //Pre and Post Filters provided by Spring Cloud Gateway
//                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
//                                .addResponseHeader("second-response", "second-response-header"))
//                        .uri("http://localhost:8084/")
//                        .id("merchantModule"))
//                .build();
//    }

}