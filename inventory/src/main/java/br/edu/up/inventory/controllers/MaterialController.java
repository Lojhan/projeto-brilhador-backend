package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Material;
import br.edu.up.inventory.repository.MaterialRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/material")
public class MaterialController {

    private final MaterialRepository repository;

    MaterialController(MaterialRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Material> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Material buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping()
    Material incluir(@RequestBody Material novoMaterial) {
        return repository.save(novoMaterial);
    }

    @PutMapping("/{id}")
    Material atualizar(@RequestBody Material materialAtualizado, @PathVariable Long id) {
        return repository.findById(id)
                .map(material -> {
                    // id encontrado
                    material.atualizarMaterial(materialAtualizado);
                    return repository.save(material);
                })
                .orElseGet(() -> {
                    // id não encontrado
                    materialAtualizado.setId(id);
                    return repository.save(materialAtualizado);
                });
    }

    @DeleteMapping("/material/{id}")
    void excluir(@PathVariable long id) {
        repository.deleteById(id);
    }

}