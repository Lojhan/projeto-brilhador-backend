package com.supplyChain.supplyChainProject.controllers;

import com.supplyChain.supplyChainProject.repositories.RelEstrRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelEstrController {
    private RelEstrRepository _repository;

    RelEstrController(RelEstrRepository repository) {
        _repository = repository;
    }
}
