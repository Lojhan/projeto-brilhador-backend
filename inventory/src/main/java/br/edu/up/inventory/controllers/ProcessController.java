package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Process;
import br.edu.up.inventory.repository.ProcessRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/processo")
public class ProcessController {

    private final ProcessRepository repository;

    ProcessController(ProcessRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Process> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Process findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping()
    Process create(@RequestBody Process novoProcess) {
        return repository.save(novoProcess);
    }

    @PutMapping("/{id}")
    Process update(@RequestBody Process processAlterado, @PathVariable Long id) {
        return repository.findById(id)
                .map(process -> {
                    // id encontrado
                    process.updateProcess(processAlterado);
                    return repository.save(process);
                })
                .orElseGet(() -> {
                    // id não encontrado
                    processAlterado.setId(id);
                    return repository.save(processAlterado);
                });
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
