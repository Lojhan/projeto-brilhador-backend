package br_up_edu.strategicsystemsproject.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br_up_edu.strategicsystemsproject.domain.Area;
import br_up_edu.strategicsystemsproject.repository.AreaRepository;


@RestController
public class AreaStrategicsController {
    
    private final AreaRepository repository;


    AreaStrategicsController(AreaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/areas")
    Iterable<Area> list() {
        return repository.findAll();
    }

    @GetMapping("/areas/{id}")
    Area findAreaById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/areas")
    Area include(@RequestBody Area newArea){
        return repository.save(newArea);
    }

    @PutMapping("/areas/{id}")
    Area update(@RequestBody Area areaUpdated, @PathVariable Long id){
        return repository.findById(id)
        .map(Area -> {
            Area.setName(areaUpdated.getName());
            return repository.save(Area);
        })
        .orElseGet(() -> {
            areaUpdated.setId(id);
            return repository.save(areaUpdated);
        });    
    }

    @DeleteMapping("/areas/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
