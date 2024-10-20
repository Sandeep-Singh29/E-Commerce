package com.springbootmicroserviceweek3.ecommerce.apigatewa.filters;

import com.springbootmicroserviceweek3.ecommerce.apigatewa.service.JwtService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


/**
 * Author: SANDEEP
 * Date: 20/10/24
 */

@Component
@Slf4j
public class AuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {

    private final JwtService jwtService;

    public AuthenticationGatewayFilterFactory(JwtService jwtService) {
        super(Config.class);
        this.jwtService = jwtService;
    }


    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String authorization = exchange.getRequest().getHeaders().getFirst("Authorization");

            if (authorization == null) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            String token = authorization.substring(7);
            Long userIdByToken = jwtService.getUserIdByToken(token);

            exchange.getRequest()
                    .mutate()
                    .header("X-User-Id", userIdByToken.toString())
                    .build();

            return chain.filter(exchange);
        };
    }

    @Data
    public static class Config {
        private boolean isEnabled;

    }

}
