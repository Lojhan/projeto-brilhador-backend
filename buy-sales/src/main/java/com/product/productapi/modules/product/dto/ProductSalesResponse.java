package com.product.productapi.modules.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.product.productapi.modules.category.dto.CategoryResponse;
import com.product.productapi.modules.product.model.Product;
import com.product.productapi.modules.supplier.dto.SupplierResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSalesResponse {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String desc;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    private SupplierResponse supplier;
    private CategoryResponse category;
    private List<String> sales;

    public static ProductSalesResponse of(Product product, List<String> sales) {
        return ProductSalesResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .desc(product.getDesc())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .createdAt(product.getCreatedAt())
                .supplier(SupplierResponse.of(product.getSupplier()))
                .category(CategoryResponse.of(product.getCategory()))
                .sales(sales)
                .build();


    }

}
