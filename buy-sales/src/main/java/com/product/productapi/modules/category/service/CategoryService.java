package com.product.productapi.modules.category.service;



import com.product.productapi.config.exceptions.ValidationException;
import com.product.productapi.config.responses.Response;
import com.product.productapi.config.validations.Validations;
import com.product.productapi.modules.category.dto.CategoryRequest;
import com.product.productapi.modules.category.dto.CategoryResponse;
import com.product.productapi.modules.category.model.Category;
import com.product.productapi.modules.category.repository.CategoryRepository;
import com.product.productapi.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Validations validations;
    @Autowired
    private ProductService productService;

    public CategoryResponse save(CategoryRequest categoryRequest) {
        validations.validateCategory(categoryRequest);
        Category savedCategory = categoryRepository.save(Category.of(categoryRequest));
        return CategoryResponse.of(savedCategory);
    }

    public CategoryResponse update(CategoryRequest categoryRequest, Integer id) {
        validations.validateCategory(categoryRequest);
        var category = Category.of(categoryRequest);
        category.setId(id);
        categoryRepository.save(category);
        return CategoryResponse.of(category);
    }

    public Category findById(Integer id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("No category found for the id: " + id));
    }

    public CategoryResponse findByIdResponse(Integer id) {
        return CategoryResponse.of(findById(id));
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public List<CategoryResponse> findByDesc(String desc) {
        return categoryRepository
                .findByDescIgnoreCaseContaining(desc)
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public Response delete(Integer id) {
        if(productService.existsByCategoryId(id)) {
            throw new ValidationException("You cannot delete this category because it has a product attached to it");
        }
        categoryRepository.deleteById(id);
        return Response.successResponse("Category deleted, category's id: " + id);

    }

}
