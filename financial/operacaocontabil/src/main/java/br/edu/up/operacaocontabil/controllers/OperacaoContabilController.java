package br.edu.up.operacaocontabil.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.operacaocontabil.domain.OperacaoContabil;
import br.edu.up.operacaocontabil.repository.OperacaoContabilRepository;

@RestController
public class OperacaoContabilController {
    private final OperacaoContabilRepository repository;

    OperacaoContabilController(OperacaoContabilRepository repository){
        this.repository = repository;
    }

    @GetMapping("/operacaocontabil")
    Iterable<OperacaoContabil> listar(){
        return repository.findAll();
    }

    @GetMapping("/operacaocontabil/{id}")
    OperacaoContabil buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/operacaocontabil")
    OperacaoContabil incluir(@RequestBody OperacaoContabil novaOperacaoContabil){
        return repository.save(novaOperacaoContabil);
    }


    @PutMapping("/operacaocontabil/{id}")
    OperacaoContabil atualizar(@RequestBody OperacaoContabil operacaoContabilAlterada, @PathVariable Long id){
        return repository.findById(id)
        .map(opc -> {
            opc.setDescricao(operacaoContabilAlterada.getDescricao());
            opc.setCodigo(operacaoContabilAlterada.getCodigo());
            opc.setCfop(operacaoContabilAlterada.getCfop());
            return repository.save(opc);
        })
        .orElseGet(() -> {
            operacaoContabilAlterada.setId(id);
            return repository.save(operacaoContabilAlterada);
        });
    }

    @DeleteMapping("/operacaocontabil/{id}")
    void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
