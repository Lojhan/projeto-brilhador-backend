package br_up_edu.strategicsystemsproject.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br_up_edu.strategicsystemsproject.domain.Task;
import br_up_edu.strategicsystemsproject.repository.TaskRepository;

@RestController
public class TaskController {
    
    public final TaskRepository repository;

    TaskController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping("/tasks")
    Iterable<Task> list() {
        return repository.findAll();
    }
    
    @GetMapping("/tasks/{id}")
    Task findTaskById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/tasks")
    Task include(@RequestBody Task newTask){
        return repository.save(newTask);
    }

    @PutMapping("/tasks/{id}")
    Task update(@RequestBody Task taskUpdated, @PathVariable Long id){
        return repository.findById(id)
        .map(Task -> {
            Task.setName(taskUpdated.getName());
            return repository.save(Task);
        })
        .orElseGet(() -> {
            taskUpdated.setId(id);
            return repository.save(taskUpdated);
        });    
    }

    @DeleteMapping("/tasks/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }


    
}
