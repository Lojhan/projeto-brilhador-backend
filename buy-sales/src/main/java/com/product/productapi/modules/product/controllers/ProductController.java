package com.product.productapi.modules.product.controllers;


import com.product.productapi.config.responses.Response;
import com.product.productapi.modules.product.dto.ProductCheckStockRequest;
import com.product.productapi.modules.product.dto.ProductRequest;
import com.product.productapi.modules.product.dto.ProductResponse;
import com.product.productapi.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public ProductResponse save(@RequestBody ProductRequest productRequest) {
        return productService.save(productRequest);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @GetMapping("/name/{name}")
    public List<ProductResponse> findByName(@PathVariable String name) {

        return productService.findByName(name);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<ProductResponse> findBySupplierId(@PathVariable Integer supplierId) {
        return productService.findBySupplierId(supplierId);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductResponse> findByCategoryId(@PathVariable Integer categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    @GetMapping("/category/name/{categoryDesc}")
    public List<ProductResponse> findByCategoryDesc(@PathVariable String categoryDesc) {
        return productService.findByCategoryDesc(categoryDesc);
    }

    @DeleteMapping("{id}")
    public Response delete(@PathVariable Integer id){
        return productService.delete(id);

    }

    @PutMapping("{id}")
    public ProductResponse update(@RequestBody ProductRequest request, @PathVariable Integer id) {
        return productService.update(request, id);
    }

    @PostMapping("check-stock")
    public Response checkProductStock(@RequestBody ProductCheckStockRequest checkProduct) {
        return productService.checkProductStock(checkProduct);
    }

}
