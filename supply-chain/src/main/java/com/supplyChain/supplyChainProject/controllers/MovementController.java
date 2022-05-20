package com.supplyChain.supplyChainProject.controllers;

import java.util.UUID;

import com.supplyChain.supplyChainProject.models.Movement;
import com.supplyChain.supplyChainProject.repositories.MovementRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MovementController {

    private final MovementRepository repository;

    MovementController(MovementRepository repository){
        this.repository = repository;
    }

    @GetMapping("/movements")
    Iterable<Movement> listar(){
        return repository.findAll();
    }

    @GetMapping("/movement/{id}")
    Movement buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/movement")
    Movement incluir(@RequestBody Movement newMovement){
        return repository.save(newMovement);
    }

    @DeleteMapping("movement/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
}
