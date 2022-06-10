package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.*;
import br.edu.up.inventory.domain.Process;
import br.edu.up.inventory.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/process")
public class ProcessController {

    private final ProcessRepository repository;
    private final ProductRepository productRepository;
    private final IngredientRepository ingredientRepository;
    private final WarehouseRepository warehouseRepository;
    private final MovementRepository movementRepository;

    ProcessController(ProcessRepository repository, ProductRepository productRepository, IngredientRepository ingredientRepository, WarehouseRepository warehouseRepository, MovementRepository movementRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
        this.warehouseRepository = warehouseRepository;
        this.movementRepository = movementRepository;
    }

    @GetMapping()
    Iterable<Process> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Process findById(@PathVariable Long id) {
        Optional<Process> optionalProcess =  repository.findById(id);
        if (optionalProcess.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Process not found");
        }
        return optionalProcess.get();
    }

    @PostMapping()
    Process create(@RequestBody Process novoProcess) {
        Process auxProcess = new Process(
                novoProcess.getId(),
                novoProcess.getName(),
                novoProcess.getDescription(),
                novoProcess.getQuantityProduced(),
                novoProcess.getIdProduct()
        );
        Process createdProcess = repository.save(auxProcess);
        novoProcess.getIngredients().forEach(ingredient -> {
            ingredient.setIdProcess(createdProcess.getId());
        });
        createdProcess.setIngredients(novoProcess.getIngredients());
        return repository.save(createdProcess);
    }

    @PutMapping("/{id}")
    Process update(@RequestBody Process processAlterado, @PathVariable Long id) {
        return repository.findById(id)
                .map(process -> {
                    // id encontrado
                    process.updateProcess(processAlterado);
                    return repository.save(process);
                })
                .orElseGet(() -> {
                    // id não encontrado
                    processAlterado.setId(id);
                    return repository.save(processAlterado);
                });
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        Optional<Process> optionalProcess =  repository.findById(id);
        if (optionalProcess.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Process not found");
        }
        repository.deleteById(id);
    }

    @PostMapping("/{id}/execute")
    boolean executeProcess(@PathVariable Long id) throws IOException, InterruptedException, ResponseStatusException {
        Optional<Process> optionalProcess =  repository.findById(id);
        if (optionalProcess.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Process not found");
        }
        Process process = optionalProcess.get();

        process.getIngredients().forEach(ingredient -> {
            Optional<Product> optionalProduct = productRepository.findById(ingredient.getIdProduct());
            if (optionalProduct.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with ID \"%S\" not found", ingredient.getIdProduct()));
            }
            Product product = optionalProduct.get();
            if (product.getQuantity() < ingredient.getQuantity()) {
                throw new ResponseStatusException(
                        HttpStatus.UNPROCESSABLE_ENTITY,
                        String.format("Missing stock for product \"%S\"", product.getName())
                );
            }
        });

        process.getIngredients().forEach(ingredient -> {
            Movement movement = new Movement(
                String.format("Process execution: \"$s\"", process.getName()),
                0,
                Timestamp.from(Instant.now()),
                MovementNature.OUTGOING,
                ingredient.getIdProduct()
            );

            Optional<Product> optionalProduct = productRepository.findById(ingredient.getIdProduct());
            if (optionalProduct.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with ID \"%S\" not found", ingredient.getIdProduct()));
            }
            Product product = optionalProduct.get();
            product.setQuantity(product.getQuantity() - ingredient.getQuantity());

            productRepository.save(product);
            movementRepository.save(movement);

            String json = String.format(
                    "{ \"type\":\"%s\", \"quantity\": %s, \"product_id\": %s, \"current_stock_quantity\": %s }",
                    movement.getNature() == MovementNature.INCOMING ? "input" : "output",
                    movement.getQuantity(),
                    movement.getIdProduct(),
                    product.getQuantity()
            );

            try {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(json))
                        .uri(URI.create("http://supply-chain-movement-brilhador/movement"))
                        .header("Content-Type", "application/json")
                        .build();

                HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(res.statusCode());
                System.out.println(res.request());
                System.out.println(res.body());

            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        });

        Movement movement = new Movement(
                String.format("Process execution: \"$s\"", process.getName()),
                0,
                Timestamp.from(Instant.now()),
                MovementNature.INCOMING,
                process.getIdProduct()
        );

        Optional<Product> optionalProducedProduct = productRepository.findById(process.getIdProduct());
        if (optionalProducedProduct.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        Product producedProduct = optionalProducedProduct.get();
        producedProduct.setQuantity(producedProduct.getQuantity() + process.getQuantityProduced());

        if (producedProduct.getIdWarehouse() == 1) {
            Iterable<Warehouse> iterable = warehouseRepository.findAll();
            Stream<Warehouse> warehouseStream = StreamSupport.stream(iterable.spliterator(), false);
            List<Warehouse> warehouses = warehouseStream
                    .filter(warehouse -> !warehouse.getIsFull())
                    .collect(Collectors.toList());

            if (warehouses.size() <= 0) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "No warehouses available");
            }

            producedProduct.setIdWarehouse(warehouses.get(0).getId());
        }

        productRepository.save(producedProduct);
        movementRepository.save(movement);

        String json = String.format(
            "{ \"type\":\"%s\", \"quantity\": %s, \"product_id\": %s, \"current_stock_quantity\": %s }",
            movement.getNature() == MovementNature.INCOMING ? "input" : "output",
            movement.getQuantity(),
            movement.getIdProduct(),
            process.getQuantityProduced()
        );

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://supply-chain-movement-brilhador/movement"))
                .header("Content-Type", "application/json")
                .build();

            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(res.statusCode());
            System.out.println(res.request());
            System.out.println(res.body());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return true;
    }

}
