package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Movement;
import br.edu.up.inventory.domain.MovementNature;
import br.edu.up.inventory.domain.Product;
import br.edu.up.inventory.repository.MovementRepository;
import br.edu.up.inventory.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/movement")
public class MovementController {

    private final MovementRepository repository;
    private final ProductRepository productRepository;

    MovementController(MovementRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    @GetMapping()
    Iterable<Movement> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Movement findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping()
    Movement create(@RequestBody Movement newMovement) throws IOException, InterruptedException {

        Movement result = repository.save(newMovement);

        Product product = productRepository.findById(result.getIdProduct()).get();
        int newQuantity = product.getQuantity();
        if (result.getNature() == MovementNature.INCOMING) {
            newQuantity += newMovement.getQuantity();
        } else {
            newQuantity -= newMovement.getQuantity();
        }
        product.setQuantity(newQuantity);
        productRepository.save(product);

        String json = String.format(
                "{ \"type\":\"%s\", \"quantity\": %s, \"product_id\": %s, \"current_stock_quantity\": %s }",
                result.getNature() == MovementNature.INCOMING ? "input" : "output",
                result.getQuantity(),
                result.getIdProduct(),
                newQuantity
        );

        // create a client
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://supply-chain-brilhador/supply-chain/movement"))
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());

        return result;
    }

    @PutMapping("/{id}")
    Movement update(@RequestBody Movement movementChanged, @PathVariable Long id) {
        return repository.findById(id)
                .map(movement -> {
                    // id encontrado
                    movement.updateMovement(movementChanged);
                    return repository.save(movement);
                })
                .orElseGet(() -> {
                    // id não encontrado
                    movementChanged.setId(id);
                    return repository.save(movementChanged);
                });
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
