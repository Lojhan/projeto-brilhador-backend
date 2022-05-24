package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Movement;
import br.edu.up.inventory.repository.MovementRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movement")
public class MovementController {

    private final MovementRepository repository;

    MovementController(MovementRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Movement> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Movement findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping()
    Movement include(@RequestBody Movement newMovement) {
        return repository.save(newMovement);
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
