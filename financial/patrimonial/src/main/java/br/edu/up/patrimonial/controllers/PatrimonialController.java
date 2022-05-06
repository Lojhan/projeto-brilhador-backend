package br.edu.up.patrimonial.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.patrimonial.domain.Patrimonial;
import br.edu.up.patrimonial.repository.PatrimonialRepository;

@RestController
public class PatrimonialController {
    
    private final PatrimonialRepository repository;

    PatrimonialController(PatrimonialRepository repository){
        this.repository = repository;
    }

    @GetMapping("/patrimonial")
    Iterable<Patrimonial> listar(){
        return repository.findAll();
    }

    @GetMapping("/patrimonial/{id}")
    Patrimonial buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/patrimonial")
    Patrimonial incluir(@RequestBody Patrimonial novoPatrimonial){
        return repository.save(novoPatrimonial);
    }


    @PutMapping("/patrimonial/{id}")
    Patrimonial atualizar(@RequestBody Patrimonial patrimonialAlterado, @PathVariable Long id){
        return repository.findById(id)
        .map(pat -> {
            pat.setNome(patrimonialAlterado.getNome());
            pat.setValor(patrimonialAlterado.getValor());
            pat.setDataEntrada(patrimonialAlterado.getDataEntrada());
            pat.setDataSaida(patrimonialAlterado.getDataSaida());
            pat.setCreditoPis(patrimonialAlterado.getCreditoPis());
            pat.setCreditoCofins(patrimonialAlterado.getCreditoCofins());
            return repository.save(pat);
        })
        .orElseGet(() -> {
            patrimonialAlterado.setId(id);
            return repository.save(patrimonialAlterado);
        });    
    }

    @DeleteMapping("/patrimonial/{id}")
    void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }



}
