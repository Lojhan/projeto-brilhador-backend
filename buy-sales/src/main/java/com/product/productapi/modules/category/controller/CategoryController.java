package com.product.productapi.modules.category.controller;

import com.product.productapi.config.responses.Response;
import com.product.productapi.modules.category.dto.CategoryRequest;
import com.product.productapi.modules.category.dto.CategoryResponse;
import com.product.productapi.modules.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest request) {

        return categoryService.save(request);
    }

    @GetMapping
    public List<CategoryResponse> findAll() {
       return categoryService.findAll();
    }

    @GetMapping("{id}")
    public CategoryResponse findById(@PathVariable Integer id) {
        return categoryService.findByIdResponse(id);
    }

    @GetMapping("desc/{desc}")
    public List<CategoryResponse> findByDesc(@PathVariable String desc) {
        return categoryService.findByDesc(desc);
    }

    @DeleteMapping("{id}")
    public Response delete(@PathVariable Integer id){
        return categoryService.delete(id);

    }

    @PutMapping("{id}")
    public CategoryResponse update(@RequestBody CategoryRequest request, @PathVariable Integer id) {
        return categoryService.update(request, id);
    }


}
