package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Product;
import br.edu.up.inventory.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Product> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Product findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping()
    Product create(@RequestBody Product novoProduct) {
        return repository.save(novoProduct);
    }

    @PutMapping("/{id}")
    Product update(@RequestBody Product productAlterado, @PathVariable Long id) {
        return repository.findById(id)
                .map(Product -> {
                    // id encontrado
                    Product.updateProduct(productAlterado);
                    return repository.save(Product);
                })
                .orElseGet(() -> {
                    // id não encontrado
                    productAlterado.setId(id);
                    return repository.save(productAlterado);
                });
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

