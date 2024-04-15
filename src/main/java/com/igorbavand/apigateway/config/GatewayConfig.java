package com.igorbavand.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private static final String LB_EXCEL_MANAGER = "lb://excel-manager";
    private static final String[] ROUTES_EXCEL_MANAGER = {"/api/books/**", "/api/teste/**", "/api/columns/**"};

    private static final String LB_AUTHENTICATION = "lb://authentication";
    private static final String[] ROUTES_AUTHENTICATION = {"/api/auth/**", "/api/products/**", "/api/users/**"};

    @Bean
    public RouteLocator gateway(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("excel-manager", p -> p
                .path(ROUTES_EXCEL_MANAGER)
                .uri(LB_EXCEL_MANAGER)
            ).route("authentication", p -> p
                .path(ROUTES_AUTHENTICATION)
                .uri(LB_AUTHENTICATION)
            )
            .build();
    }
}
