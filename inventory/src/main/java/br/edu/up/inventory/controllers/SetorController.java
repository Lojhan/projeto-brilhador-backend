package br.edu.up.inventory.controllers;

import br.edu.up.inventory.repository.SetorRepository;
import br.edu.up.inventory.domain.Setor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/setor")
public class SetorController {

    private final SetorRepository repository;

    SetorController(SetorRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Setor> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Setor buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping()
    Setor incluir(@RequestBody Setor novoSetor) {
        return repository.save(novoSetor);
    }

    @PutMapping("/{id}")
    Setor atualizar(@RequestBody Setor setorAlterado, @PathVariable Long id) {
        return repository.findById(id)
                .map(setor -> {
                    // id encontrado
                    setor.atualizarSetor(setorAlterado);
                    return repository.save(setor);
                })
                .orElseGet(() -> {
                    // id não encontrado
                    setorAlterado.setId(id);
                    return repository.save(setorAlterado);
                });
    }

    @DeleteMapping("/{id}")
    void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
