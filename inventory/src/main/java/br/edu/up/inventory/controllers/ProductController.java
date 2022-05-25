package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Product;
import br.edu.up.inventory.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

