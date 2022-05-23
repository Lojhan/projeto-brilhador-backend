package com.product.productapi.modules.supplier.controller;

import com.product.productapi.config.responses.Response;
import com.product.productapi.modules.supplier.dto.SupplierRequest;
import com.product.productapi.modules.supplier.dto.SupplierResponse;
import com.product.productapi.modules.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api/supplier")
public class SupplierController {


    @Autowired
    private SupplierService supplierService;



    @PostMapping
    public SupplierResponse save(@RequestBody SupplierRequest request) {

        return supplierService.save(request);
    }

    @GetMapping
    public List<SupplierResponse> findByAll() {

        return supplierService.findAll();
    }

    @GetMapping("{id}")
    public SupplierResponse findById(@PathVariable Integer id) {
        return  supplierService.findByIdSupplierResponse(id);
    }

    @GetMapping("name/{name}")
    public List<SupplierResponse> findByName(@PathVariable String name) {
        return supplierService.findByName(name);
    }

    @DeleteMapping("{id}")
    public Response delete(@PathVariable Integer id){
        return supplierService.delete(id);

    }

    @PutMapping("{id}")
    public SupplierResponse update(@RequestBody SupplierRequest request, @PathVariable Integer id) {
        return supplierService.update(request, id);
    }

}
