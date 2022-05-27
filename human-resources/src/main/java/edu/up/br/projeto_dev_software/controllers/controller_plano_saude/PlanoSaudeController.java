package edu.up.br.projeto_dev_software.controllers.controller_plano_saude;

import edu.up.br.projeto_dev_software.domain.domain_plano_saude.PlanoSaude;
import edu.up.br.projeto_dev_software.repository.PlanoSaudeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "planoSaude")
@RestController
@RequestMapping("/planoSaude")
public class PlanoSaudeController {
    
    @Autowired
    private PlanoSaudeRepository repository;

    @GetMapping("/listar")
    Iterable<PlanoSaude> listar(){
        return repository.findAll();
    }

    @GetMapping("/listar/{id}")
    PlanoSaude buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/incluir")
    PlanoSaude incluir(@RequestBody PlanoSaude novoPlano){
        return repository.save(novoPlano);
    }

    @PutMapping("/atualizar/{id}")
    PlanoSaude atualizar(@RequestBody PlanoSaude planoAlterado, @PathVariable Long id){
        return repository.findById(id)
        .map(planosaude -> {
            planosaude.setNomePlano(planoAlterado.getNomePlano());
            planosaude.setValorPlano(planoAlterado.getValorPlano());
            return repository.save(planosaude);
        })
        .orElseGet(() -> {
            planoAlterado.setId(id);
            return repository.save(planoAlterado);
        });    
    }
    
    @DeleteMapping("/deletar/{id}")
    void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }    
}