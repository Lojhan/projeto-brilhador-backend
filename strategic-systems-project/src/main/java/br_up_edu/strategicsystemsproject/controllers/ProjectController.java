package br_up_edu.strategicsystemsproject.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br_up_edu.strategicsystemsproject.domain.Area;
import br_up_edu.strategicsystemsproject.domain.Project;
import br_up_edu.strategicsystemsproject.repository.ProjectRepository;

@RestController
public class ProjectController {

    private final ProjectRepository repository;

    ProjectController(ProjectRepository repository){
        this.repository = repository;
    }

    @GetMapping("/projects")
    Iterable<Project> list() {
        return repository.findAll();
    }

    @GetMapping("/projects/{id}")
    Project findProjectById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @GetMapping("/projects/{id}")
    Project findAreaByProject(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/projects")
    Project include(@RequestBody Project newProject){
        return repository.save(newProject);
    }

    @PutMapping("/projects/{id}")
    Project update(@RequestBody Project projectUpdated, @PathVariable Long id){
        return repository.findById(id)
        .map(Project -> {
            Project.setName(projectUpdated.getName());
            return repository.save(Project);
        })
        .orElseGet(() -> {
            projectUpdated.setId(id);
            return repository.save(projectUpdated);
        });    
    }

    @DeleteMapping("/projects/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
