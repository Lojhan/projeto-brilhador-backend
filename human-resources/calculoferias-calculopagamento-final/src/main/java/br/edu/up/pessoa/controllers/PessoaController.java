package br.edu.up.pessoa.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.pessoa.domain.Pessoa;
import br.edu.up.pessoa.repository.PessoaRepository;

@RestController
public class PessoaController {
    
    private final PessoaRepository repository;

    PessoaController(PessoaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/pessoas")
    Iterable<Pessoa> listar(){
        return repository.findAll();
    }

    @GetMapping("/pessoas/{id}")
    Pessoa buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }
    
    @GetMapping("/pessoas/calculoFerias/{id}")
    Pessoa calculoFerias(@PathVariable Long id){
    	Pessoa p = new Pessoa();
    	p = repository.findById(id).get();
    	p = PessoaRepository.calculoFerias(p);
    	repository.save(p);
        return p;
    }
    
    @GetMapping("/pessoas/calculoSalario/{id}/{horaExtra}")
    Pessoa calculoSalario(@PathVariable Long id, @PathVariable int horaExtra){
    	Pessoa p = new Pessoa();
    	p = repository.findById(id).get();
    	p = PessoaRepository.calculoSalario(p, horaExtra);
    	repository.save(p);
        return p;
    }


    @PostMapping("/pessoas")
    Pessoa incluir(@RequestBody Pessoa novaPessoa){
        return repository.save(novaPessoa);
    }


    @PutMapping("/pessoas/{id}")
    Pessoa atualizar(@RequestBody Pessoa pessoaAlterada, @PathVariable Long id){
        return repository.findById(id)
        .map(pessoa -> {        	
            pessoa.setNome(pessoaAlterada.getNome());
            pessoa.setCpf(pessoaAlterada.getCpf());
            pessoa.setDtContratacao(pessoaAlterada.getDtContratacao());
            pessoa.setDtNasc(pessoaAlterada.getDtNasc());
            pessoa.setEmail(pessoaAlterada.getEmail());
            pessoa.setSalario(pessoaAlterada.getSalario());
            pessoa.setBanco(pessoaAlterada.getBanco());
            pessoa.setAgencia(pessoaAlterada.getAgencia());
            pessoa.setConta(pessoaAlterada.getConta());
            return repository.save(pessoa);
        })
        .orElseGet(() -> {
            pessoaAlterada.setId(id);
            return repository.save(pessoaAlterada);
        });    
    }

    @DeleteMapping("/pessoas/{id}")
    void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
