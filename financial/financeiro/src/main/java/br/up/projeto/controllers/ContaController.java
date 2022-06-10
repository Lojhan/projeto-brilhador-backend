package br.up.projeto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.up.projeto.domain.Conta;
import br.up.projeto.repository.ContaRepository;

@RestController
public class ContaController {
    
    private final ContaRepository repository;

    ContaController(ContaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/conta")
    Iterable<Conta> listar(){
        return repository.findAll();
    }

    @GetMapping("/conta/{id}")
    Conta buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/conta")
    Conta incluir(@RequestBody Conta novaConta){
        return repository.save(novaConta);
    }


    @PutMapping("/conta/{id}")
    Conta atualizar(@RequestBody Conta contaAlterada, @PathVariable Long id){
        return repository.findById(id)
        .map(moeda -> {
            moeda.setNome(contaAlterada.getNome());
            moeda.setCodigo(contaAlterada.getCodigo());
            moeda.setAgencia(contaAlterada.getAgencia());
            moeda.setBanco(contaAlterada.getBanco());
            return repository.save(moeda);
        })
        .orElseGet(() -> {
            contaAlterada.setId(id);
            return repository.save(contaAlterada);
        });    
    }

    @DeleteMapping("/conta/{id}")
    void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
