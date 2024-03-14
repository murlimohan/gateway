package com.murli.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
        .route("product-service", r -> r.path("/api/products/**")
            .uri("lb://product-service"))
        .route("order-service", r -> r.path("/api/orders/**", "/api/order-items/**")
            .uri("lb://order-service"))
        .build();
  }

}
