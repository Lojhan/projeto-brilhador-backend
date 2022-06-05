package br.up.projeto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.up.projeto.domain.LancamentoValor;
import br.up.projeto.repository.LancamentoValorRepository;

@RestController
public class LancamentoValorController {
    
    private final LancamentoValorRepository repository;

    LancamentoValorController(LancamentoValorRepository repository){
        this.repository = repository;
    }

    @GetMapping("/lancamento-valor")
    Iterable<LancamentoValor> listar(){
        return repository.findAll();
    }

    @GetMapping("/lancamento-valor/{id}")
    LancamentoValor buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/lancamento-valor")
    LancamentoValor incluir(@RequestBody LancamentoValor novoLancamentoValor){
        return repository.save(novoLancamentoValor);
    }

    @PutMapping("/lancamento-valor/{id}")
    LancamentoValor atualizar(@RequestBody LancamentoValor LancamentoValorAlterado, @PathVariable Long id){
        return repository.findById(id).map(lancamento -> {
            lancamento.setData(LancamentoValorAlterado.getData());
            lancamento.setValor(LancamentoValorAlterado.getValor());
            lancamento.setCliente(LancamentoValorAlterado.getCliente());
            lancamento.setConta(LancamentoValorAlterado.getConta());
            lancamento.setMeioPagamento(LancamentoValorAlterado.getMeioPagamento());
            return repository.save(lancamento);
        })
        .orElseGet(() -> {
            LancamentoValorAlterado.setId(id);
            return repository.save(LancamentoValorAlterado);
        });
    }
        
    @DeleteMapping("/lancamento-valor/{id}")
    void excluir(@PathVariable Long id){
        repository.deleteById(id);
    } 
}
