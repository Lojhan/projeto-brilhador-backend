package com.product.productapi.modules.product.model;

import com.product.productapi.modules.category.model.Category;
import com.product.productapi.modules.product.dto.ProductRequest;
import com.product.productapi.modules.supplier.model.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    @Column(name = "description")
    private String desc;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void preSetCreatedAt(){
        createdAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "FK_SUPPLIER", nullable = false)
    private Supplier supplier;

    public static Product of(ProductRequest productRequest, Category category, Supplier supplier) {
        return Product
                .builder()
                .name(productRequest.getName())
                .desc(productRequest.getDesc())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .category(category)
                .supplier(supplier)
                .build();
    }

    public void updateStock(Integer quantity) {
        this.quantity = this.quantity - quantity;
    }
}
