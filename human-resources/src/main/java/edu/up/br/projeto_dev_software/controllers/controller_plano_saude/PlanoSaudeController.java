package edu.up.br.projeto_dev_software.controllers.controller_plano_saude;

import edu.up.br.projeto_dev_software.domain.domain_plano_saude.PlanoSaude;
import edu.up.br.projeto_dev_software.repository.PlanoSaudeRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanoSaudeController {
    
    private final PlanoSaudeRepository repository;

    PlanoSaudeController(PlanoSaudeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/planos")
    Iterable<PlanoSaude> listar(){
        return repository.findAll();
    }

    @GetMapping("/planos/{id}")
    PlanoSaude buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/planos")
    PlanoSaude incluir(@RequestBody PlanoSaude novoPlano){
        return repository.save(novoPlano);
    }


    @PutMapping("/planos/{id}")
    PlanoSaude atualizar(@RequestBody PlanoSaude planoAlterado, @PathVariable Long id){
        return repository.findById(id)
        .map(planosaude -> {
            planosaude.setnomePlano(planoAlterado.getnomePlano());
            return repository.save(planosaude);
        })
        .orElseGet(() -> {
            planoAlterado.setId(id);
            return repository.save(planoAlterado);
        });    
    }

    @DeleteMapping("/planos/{id}")
    void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}