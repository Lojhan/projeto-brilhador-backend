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

    @PostMapping("/create-task")
        // create a new task
    EmployeeTask newTask(@RequestBody EmployeeTask task) {
        try {
            task.Validate();
            System.out.println(task.toString());

            if(!task.IsValid) {
                return null;
            }

            return _repository.save(task);
        } catch (Exception e) {
            throw new RuntimeException("newTask{" + task.toString() + "}", e);
        }
    }

    @GetMapping("/tasks")
        // lists all tasks
    Iterable<EmployeeTask> getAllTasks() {

        try {
            return _repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("getAllTasks", e);
        }
    }

    @GetMapping("/task/{id}")
        // find task by id
    EmployeeTask taskById(@PathVariable Long id) {
        try {
            return _repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("taskById::{" + id.toString() + "}", e);
        }
    }
}
