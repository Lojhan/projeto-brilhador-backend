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
        // default warehouse, used by new products that haven't had any movements
        // always set to full so that products can only be moved here manually and not through movements
        this.create(new Warehouse(1, "Not allocated", true));
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
