package com.springbootmicroserviceweek3.ecommerce.apigatewa.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.swing.*;

/**
 * Author: SANDEEP
 * Date: 20/10/24
 */

@Component
@Slf4j
public class LoggingOrderFilter extends AbstractGatewayFilterFactory<LoggingOrderFilter.Config> {

    public LoggingOrderFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("Order Filter Pre :: {}", exchange.getRequest().getURI());
            return chain.filter(exchange);
        };
    }

    public static class Config {

    }

}
