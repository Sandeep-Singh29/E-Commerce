package com.springbootmicroserviceweek3.ecommerce.inventory.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private List<OrderRequestItemDto> items;
}

