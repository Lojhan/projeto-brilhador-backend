package com.product.productapi.config.validations;

import com.product.productapi.config.exceptions.ValidationException;
import com.product.productapi.modules.category.dto.CategoryRequest;
import com.product.productapi.modules.product.dto.ProductRequest;
import com.product.productapi.modules.product.dto.ProductStock;
import com.product.productapi.modules.supplier.dto.SupplierRequest;
import org.springframework.stereotype.Component;


import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class Validations {

    public void validateCategory(CategoryRequest categoryRequest) {
        if(isEmpty(categoryRequest.getDesc())) {
            throw new ValidationException("The category's description is empty");
        }
    }

    public void validateSupplier(SupplierRequest supplierRequest) {
        if(isEmpty(supplierRequest.getName())) {
            throw new ValidationException("The supplier's name is empty");
        }
    }

    public void validateProduct(ProductRequest productRequest) {
        if(isEmpty(productRequest.getName())) {
            throw new ValidationException("The product's name is empty");
        }
        else if(isEmpty(productRequest.getPrice())) {
            throw new ValidationException("The product must have a price");
        }
        else if(isEmpty(productRequest.getQuantity())) {
            throw new ValidationException("The quantity available of the product must to be informed");
        }
        else if(isEmpty(productRequest.getCategoryId())) {
            throw new ValidationException("The product must have a category");
        }
        else if(isEmpty(productRequest.getSupplierId())) {
            throw new ValidationException("The product must have a supplier");
        }

    }

    public void validateStockData(ProductStock productStock) {
        if(isEmpty(productStock) || isEmpty(productStock.getSalesId())) {
            throw new ValidationException("Product data is empty");
        }
        if(isEmpty(productStock.getProducts())){
            throw new ValidationException("Sales' product must be informed");
        }
        productStock
                .getProducts()
                .forEach(salesProduct -> {
                    if(isEmpty(salesProduct.getQuantity()) || isEmpty(salesProduct.getProductId())) {
                        throw new ValidationException("Product id and product quantity must be informed");
                    }
        });
    }

}
