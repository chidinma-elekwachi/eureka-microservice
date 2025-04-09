package com.example.ApiGateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
    public CustomFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            String authorization = exchange.getRequest().getHeaders().get("Authorization").get(0);
            String oauthKey = authorization.replace("Bearer ", "");
            if (oauthKey.length() >= 20){
                return chain.filter(exchange);
            }
            return Mono.error(new Exception("Invalid Token"));
        });
    }

    public static class Config {

    }

}
