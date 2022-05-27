package com.product.productapi.modules.category.repository;

import com.product.productapi.modules.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByDescIgnoreCaseContaining(String desc);

}
