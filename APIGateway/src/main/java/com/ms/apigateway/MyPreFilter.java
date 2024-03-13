package com.ms.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.*;

@Component
public class MyPreFilter implements GlobalFilter {

    Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("filter() method executed!");

        // Access Request Information sent to API Gateway
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders(); // Header for a request
        Set<String> keySet = headers.keySet(); // Header's Key-Value Pair Data

        keySet.forEach(key -> {
            List<String> values = headers.get(key); // fetched the values
            System.out.println(key + "::" + values); // show Key :: Value
            }
        );
        return chain.filter(exchange); // Process Next Request
    }
}
