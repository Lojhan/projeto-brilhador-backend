package com.supplyChain.supplyChainProject.controllers;

import com.supplyChain.supplyChainProject.models.RelEstr;
import com.supplyChain.supplyChainProject.repositories.RelEstrRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RelEstrController {
    private RelEstrRepository _repository;

    RelEstrController(RelEstrRepository repository) {
        _repository = repository;
    }

    @PostMapping("/create-relationship")
    RelEstr novaCompra(@RequestBody RelEstr relationship) {

        return _repository.save(relationship);
    }

    @GetMapping("/relationship/{id}")
    RelEstr buscarPorId(@PathVariable Long id){
        return _repository.findById(id).get();
    }
}
