package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Warehouse;
import br.edu.up.inventory.repository.WarehouseRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseRepository repository;

    WarehouseController(WarehouseRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Warehouse> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Warehouse findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping()
    Warehouse create(@RequestBody Warehouse newWarehouse) {
        return repository.save(newWarehouse);
    }

    @PutMapping("/{id}")
    Warehouse update(@RequestBody Warehouse warehouseChanged, @PathVariable Long id) {
        return repository.findById(id)
                .map(warehouse -> {
                    // id encontrado
                    warehouse.updateWarehouse(warehouseChanged);
                    return repository.save(warehouse);
                })
                .orElseGet(() -> {
                    // id não encontrado
                    warehouseChanged.setId(id);
                    return repository.save(warehouseChanged);
                });
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
