package com.example.ApiGateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class GlobalFilter2 {

    @Bean
    @Order(1)
    public GlobalFilter filter1(){
        return ((exchange, chain) -> {
            System.out.println("This is a global filter 2");
            return chain.filter(exchange);
        });
    }

    @Bean
    @Order(3)
    public GlobalFilter filter2(){
        return ((exchange, chain) -> {
            System.out.println("This is a global filter 3");
            return chain.filter(exchange);
        });
    }
    @Bean
    @Order(0)
    public GlobalFilter filter3(){
        return ((exchange, chain) -> {
            System.out.println("This is a global filter 4");
            return chain.filter(exchange);
        });
    }

}
