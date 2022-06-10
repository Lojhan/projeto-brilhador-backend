package com.supplyChain.supplyChainProject.repositories;


import com.supplyChain.supplyChainProject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
