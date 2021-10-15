package com.cgGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class APIGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(APIGatewayApplication.class, args);
    }

    @Bean
    public GlobalFilter globalFilter() {
        return (exchange, chain) -> {
            System.out.println("First Global filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("Second Global filter");
            }));
        };
    }
}
