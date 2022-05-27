package com.product.productapi.modules.supplier.service;

import com.product.productapi.config.exceptions.ValidationException;
import com.product.productapi.config.responses.Response;
import com.product.productapi.config.validations.Validations;
import com.product.productapi.modules.product.service.ProductService;
import com.product.productapi.modules.supplier.dto.SupplierRequest;
import com.product.productapi.modules.supplier.dto.SupplierResponse;
import com.product.productapi.modules.supplier.model.Supplier;
import com.product.productapi.modules.supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private Validations validations;
    @Autowired
    private ProductService productService;


    public SupplierResponse save(SupplierRequest supplierRequest) {
        validations.validateSupplier(supplierRequest);
        Supplier savedSupplier = supplierRepository.save(Supplier.of(supplierRequest));
        return SupplierResponse.of(savedSupplier);
    }

    public SupplierResponse update(SupplierRequest supplierRequest, Integer id) {
        validations.validateSupplier(supplierRequest);
        var supplier = Supplier.of(supplierRequest);
        supplier.setId(id);;
        supplierRepository.save(supplier);
        return SupplierResponse.of(supplier);
    }

    public SupplierResponse findByIdSupplierResponse(Integer id) {
        return SupplierResponse.of(findById(id));
    }

    public Supplier findById(Integer id) {
         return supplierRepository
                 .findById(id)
                 .orElseThrow(() -> new ValidationException("No supplier found for the id: " + id));
    }

    public List<SupplierResponse> findAll() {
        return supplierRepository
                .findAll()
                .stream()
                .map(SupplierResponse::of)
                .collect(Collectors.toList());
    }

    public List<SupplierResponse> findByName(String name) {
        return supplierRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(SupplierResponse::of)
                .collect(Collectors.toList());
    }

    public Response delete(Integer id) {
        if(productService.existsBySupplierId(id)) {
            throw new ValidationException("You cannot delete this supplier because it has a product attached to it");
        }
        supplierRepository.deleteById(id);
        return Response.successResponse("Supplier deleted, supplier's id: " + id);

    }



}
