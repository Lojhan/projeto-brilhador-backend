package com.supplyChain.supplyChainProject.controllers;

import com.supplyChain.supplyChainProject.models.EmployeeTask;
import com.supplyChain.supplyChainProject.repositories.EmployeeTaskRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class EmployeeTaskController {
    private final EmployeeTaskRepository _repository;

    EmployeeTaskController(EmployeeTaskRepository repository) {
        _repository = repository;
    }

    @PostMapping("/create-task")
        // create a new task
    ResponseEntity newTask(@RequestBody EmployeeTask task) throws ExpiredJwtException, MalformedJwtException {
        try {
            task.Validate();
            System.out.println(task.toString());

            if (!task.IsValid) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Foram enviados dados inválidos");
            }

            String json = String.format(
                    "{ \"name\": \"%s\", \"description\": \"%s\", \"daysToFinish\": %s, \"status\": \"%s\" }",
                    task.getName(),
                    task.getDescription(),
                    task.getDaysToFinish(),
                    task.getStatus()
            );

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://strategic-systems-services-brilhador/tasks"))
                    .header("Accept", "*/*")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            _repository.save(task);

            return ResponseEntity.status(HttpStatus.CREATED).body(response.body().toString());
        } catch (ExpiredJwtException e) {
            throw new ExpiredJwtException(e.getHeader(), e.getClaims(), "Token expirado");
        } catch (MalformedJwtException e) {
            throw new MalformedJwtException("Token mal formado", e.getCause());
        } catch (Exception e) {
            throw new RuntimeException("newTask{" + task.toString() + "}", e);
        }
    }

    @GetMapping("/tasks")
        // lists all tasks
    ResponseEntity<Iterable<EmployeeTask>> getAllTasks() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(_repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("getAllTasks", e);
        }
    }

    @GetMapping("/task/{id}")
        // find task by id
    ResponseEntity<EmployeeTask> taskById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(_repository.findById(id).orElse(null));
        } catch (Exception e) {
            throw new RuntimeException("taskById::{" + id.toString() + "}", e);
        }
    }

    @PutMapping("/task/update/{id}")
    ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody EmployeeTask newTask) {
        return _repository.findById(id)
                .map(Task -> {
                    Task.setName(newTask.getName());
                    Task.setDaysToFinish(newTask.getDaysToFinish());
                    Task.setDescription(newTask.getDescription());
                    Task.setStatus(newTask.getStatus());
                    _repository.save(Task);
                    return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
                }).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id não encontrado."));
    }
}
