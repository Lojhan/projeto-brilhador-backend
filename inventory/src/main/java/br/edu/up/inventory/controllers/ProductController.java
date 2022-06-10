package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Product;
import br.edu.up.inventory.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    List<Product> findAll(@RequestParam(value = "filter", required = false) String filter) {
        Iterable<Product> iterable = repository.findAll();
        Stream<Product> productStream = StreamSupport.stream(iterable.spliterator(), false);

        if (filter != null && filter.equalsIgnoreCase("available")) {
            return productStream
                    .filter(product -> product.getQuantity() > 0)
                    .collect(Collectors.toList());
        }

        return productStream.collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    Product findById(@PathVariable Long id) {
        Optional<Product> optionalProduct =  repository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        return optionalProduct.get();
    }

    @PostMapping()
    Product create(@RequestBody Product novoProduct) {
        novoProduct.setQuantity(0);
        novoProduct.setIdWarehouse(1); // default warehouse
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
                    productAlterado.setQuantity(0);
                    productAlterado.setIdWarehouse(1); // default warehouse
                    return repository.save(productAlterado);
                });
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        Optional<Product> optionalProduct =  repository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        repository.deleteById(id);
    }

}

