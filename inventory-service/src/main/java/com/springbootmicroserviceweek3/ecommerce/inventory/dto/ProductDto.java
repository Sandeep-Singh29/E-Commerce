package com.springbootmicroserviceweek3.ecommerce.inventory.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private Double price;

    private Integer stock;
}
