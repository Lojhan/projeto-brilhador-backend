package com.product.productapi.modules.product.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantity {

    private Integer productId;
    private Integer quantity;

}
