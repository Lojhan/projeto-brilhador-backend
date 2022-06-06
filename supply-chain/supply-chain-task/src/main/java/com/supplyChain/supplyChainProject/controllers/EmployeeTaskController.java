package com.supplyChain.supplyChainProject.controllers;

import com.supplyChain.supplyChainProject.models.EmployeeTask;
import com.supplyChain.supplyChainProject.repositories.EmployeeTaskRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeTaskController {
    private final EmployeeTaskRepository _repository;

    EmployeeTaskController(EmployeeTaskRepository repository) {
        _repository = repository;
    }

    @PostMapping("/create-task") // create a new task
    EmployeeTask newTask(@RequestBody EmployeeTask task) {
        return _repository.save(task);
    }

    @GetMapping("/tasks") // lists all tasks
    Iterable<EmployeeTask> getAllTasks() {
        return _repository.findAll();
    }

    @GetMapping("/task/{id}") // find task by id
    EmployeeTask taskById(@PathVariable Long id) {
        return _repository.findById(id).orElse(null);
    }
}
