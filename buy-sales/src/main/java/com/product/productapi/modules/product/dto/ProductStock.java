package com.product.productapi.modules.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStock {


    private String salesId;
    private List<ProductQuantity> products;

}
