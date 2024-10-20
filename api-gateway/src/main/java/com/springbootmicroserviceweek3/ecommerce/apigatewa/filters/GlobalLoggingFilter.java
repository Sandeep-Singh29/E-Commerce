package com.springbootmicroserviceweek3.ecommerce.apigatewa.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Author: SANDEEP
 * Date: 20/10/24
 */

@Component
@Slf4j
public class GlobalLoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //Pre-Filter
        log.info("Logging From Global Pre: {}", exchange.getRequest().getURI());

        //Post-Filter
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("Logging From Global Post: {}", exchange.getResponse().getStatusCode());
        }));
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
