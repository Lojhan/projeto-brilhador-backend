package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Movement;
import br.edu.up.inventory.domain.MovementNature;
import br.edu.up.inventory.domain.Product;
import br.edu.up.inventory.domain.Warehouse;
import br.edu.up.inventory.repository.MovementRepository;
import br.edu.up.inventory.repository.ProductRepository;
import br.edu.up.inventory.repository.WarehouseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/movement")
public class MovementController {

    private final MovementRepository repository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    MovementController(MovementRepository repository, ProductRepository productRepository, WarehouseRepository warehouseRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
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
    Movement create(@RequestBody Movement newMovement) throws IOException, InterruptedException, ResponseStatusException {
        Product product = productRepository.findById(newMovement.getIdProduct()).get();
        int newQuantity = product.getQuantity();
        if (newMovement.getNature() == MovementNature.INCOMING) {
            newQuantity += newMovement.getQuantity();
            if (product.getIdWarehouse() == 1) {
                Iterable<Warehouse> iterable = warehouseRepository.findAll();
                Stream<Warehouse> warehouseStream = StreamSupport.stream(iterable.spliterator(), false);
                List<Warehouse> warehouses = warehouseStream
                    .filter(warehouse -> !warehouse.getIsFull())
                    .collect(Collectors.toList());

                if (warehouses.size() <= 0) {
                    throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "No warehouses available");
                }

                product.setIdWarehouse(warehouses.get(0).getId());
            }
        } else {
            newQuantity -= newMovement.getQuantity();
        }

        if (newQuantity <= 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Not enough products");
        }

        product.setQuantity(newQuantity);

        Movement result = repository.save(newMovement);
        productRepository.save(product);

        String json = String.format(
                "{ \"type\":\"%s\", \"quantity\": %s, \"product_id\": %s, \"current_stock_quantity\": %s }",
                result.getNature() == MovementNature.INCOMING ? "input" : "output",
                result.getQuantity(),
                result.getIdProduct(),
                newQuantity
        );

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
