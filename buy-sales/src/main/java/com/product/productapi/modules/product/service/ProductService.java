package com.product.productapi.modules.product.service;

import com.product.productapi.config.exceptions.ValidationException;
import com.product.productapi.config.responses.Response;
import com.product.productapi.config.validations.Validations;
import com.product.productapi.modules.product.dto.*;
import com.product.productapi.modules.product.model.Product;
import com.product.productapi.modules.product.repository.ProductRepository;
import com.product.productapi.modules.category.service.CategoryService;
import com.product.productapi.modules.supplier.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private Validations validations;



    public ProductResponse save(ProductRequest productRequest) {
        validations.validateProduct(productRequest);
        var category = categoryService.findById(productRequest.getCategoryId());
        var supplier = supplierService.findById(productRequest.getSupplierId());
        var product = productRepository.save(Product.of(productRequest, category, supplier));
        return ProductResponse.of(product);
    }

    public ProductResponse update(ProductRequest productRequest, Integer id) {
        if(isEmpty(id)) {
            throw new ValidationException("Product id must be informed");
        }
        validations.validateProduct(productRequest);
        var category = categoryService.findById(productRequest.getCategoryId());
        var supplier = supplierService.findById(productRequest.getSupplierId());
        var product = Product.of(productRequest, category, supplier);
        product.setId(id);
        productRepository.save(product);
        return ProductResponse.of(product);
    }

    public Product findById(Integer id) {
        if(isEmpty(id)) {
            throw new ValidationException("Product id must be informed");
        }
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no product for the given ID."));
    }

    public List<ProductResponse> findAll() {
        return productRepository.
                findAll().
                stream().
                map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> findByName(String name) {
        return productRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> findBySupplierId(Integer supplierId) {
        return productRepository
                .findBySupplierId(supplierId)
                .stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> findByCategoryId(Integer categoryId) {
        return productRepository
                .findByCategoryId(categoryId)
                .stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> findByCategoryDesc(String categoryDesc) {
        return productRepository
                .findByCategoryDescIgnoreCaseContaining(categoryDesc)
                .stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    public Response delete(Integer id) {
        productRepository.deleteById(id);
        return Response.successResponse("Product deleted");
    }

    public boolean existsByCategoryId(Integer categoryId) {
        return productRepository.existsByCategoryId(categoryId);
    }

    public boolean existsBySupplierId(Integer supplierId) {
        return productRepository.existsBySupplierId(supplierId);
    }

    @Transactional
    public void updateProductStock(ProductStock productStock) {
        try {
            validations.validateStockData(productStock);
            var productsToUpdate = new ArrayList<Product>();
            productStock
                    .getProducts()
                    .forEach(salesProduct -> {
                        var existingProducts = findById(salesProduct.getProductId());
                        validateStockQuantity(salesProduct, existingProducts);
                        existingProducts.updateStock(salesProduct.getQuantity());
                        productsToUpdate.add(existingProducts);
                    });
            if(!isEmpty(productsToUpdate)) {
                productRepository.saveAll(productsToUpdate);
            }
        }
        catch (Exception e) {
            log.info("An error occurred while updating stock. Error: " + e.getMessage(), e);

        }
    }

    public void validateStockQuantity(ProductQuantity salesProduct, Product existingProducts) {
        if(salesProduct.getQuantity() > existingProducts.getQuantity()) {
            throw new ValidationException(String.format("The product %s has only %s units available", existingProducts.getName(), existingProducts.getQuantity()));
        }
    }

    public Response checkProductStock(ProductCheckStockRequest checkProduct) {
        if(isEmpty(checkProduct)){
            throw new ValidationException("Product must be informed");
        }

        checkProduct
                .getProducts()
                .forEach(this::validateStockItems);
        return Response.successResponse("Product available");
    }

    public void validateStockItems(ProductQuantity productQuantity) {
        if(isEmpty(productQuantity.getProductId()) || isEmpty(productQuantity.getQuantity())){
            throw new ValidationException("Product id and quantity are empty and need to be informed");
        }
        var product = findById(productQuantity.getProductId());
        if(productQuantity.getQuantity() > product.getQuantity()){
            throw new ValidationException(String.format("The product %s has only %s units available", product.getName(), product.getQuantity()));
        }
    }
}
