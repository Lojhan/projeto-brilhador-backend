package br.edu.up.inventory.repository;

import br.edu.up.inventory.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{

}

