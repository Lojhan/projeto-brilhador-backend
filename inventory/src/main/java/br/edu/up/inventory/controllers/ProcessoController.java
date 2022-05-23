package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Processo;
import br.edu.up.inventory.repository.ProcessoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/processo")
public class ProcessoController {

    private final ProcessoRepository repository;

    ProcessoController(ProcessoRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Processo> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Processo buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping()
    Processo incluir(@RequestBody Processo novoProcesso) {
        return repository.save(novoProcesso);
    }

    @PutMapping("/{id}")
    Processo atualizar(@RequestBody Processo processoAlterado, @PathVariable Long id) {
        return repository.findById(id)
                .map(processo -> {
                    // id encontrado
                    processo.atualizarProcesso(processoAlterado);
                    return repository.save(processo);
                })
                .orElseGet(() -> {
                    // id não encontrado
                    processoAlterado.setId(id);
                    return repository.save(processoAlterado);
                });
    }

    @DeleteMapping("/{id}")
    void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
