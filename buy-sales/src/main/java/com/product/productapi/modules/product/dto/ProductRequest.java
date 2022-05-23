package com.product.productapi.modules.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private String name;
    private Integer quantity;
    private BigDecimal price;
    private String desc;
    private Integer supplierId;
    private Integer categoryId;
}
