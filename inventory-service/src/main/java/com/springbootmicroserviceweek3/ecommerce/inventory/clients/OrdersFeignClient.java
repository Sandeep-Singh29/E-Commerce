package com.springbootmicroserviceweek3.ecommerce.inventory.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order-service", path = "/orders")
public interface OrdersFeignClient {
    
    @GetMapping("/core/helloOrders")
    String helloOrders();
    
}
