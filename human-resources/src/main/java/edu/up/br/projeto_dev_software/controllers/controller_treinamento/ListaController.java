package edu.up.br.projeto_dev_software.controllers.controller_treinamento;

import org.springframework.web.bind.annotation.RestController;

import edu.up.br.projeto_dev_software.repository.ListaRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.up.br.projeto_dev_software.domain.domain_treinamento.*;;


@RestController
public class ListaController {

    private final ListaRepository repository;

    ListaController(ListaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/listas")
    Iterable<Lista> listar(){
        return repository.findAll();

    }

    @GetMapping("/listas/{id}")
    Lista buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }
    
    @PostMapping("/listas")
    Lista incluir(@RequestBody Lista novaLista){
        return repository.save(novaLista);
    }

    @PutMapping("/listas/{id}")
    Lista atualizar(@RequestBody Lista listaAlterada, @PathVariable Long id){
        return repository.findById(id)
        .map(lista -> {
            lista.setNome(listaAlterada.getNome());
            return repository.save(lista);
        })

        .orElseGet(() -> {
            listaAlterada.setId(id);
            return repository.save(listaAlterada);
        });    
    }

    @DeleteMapping("/listas/{id}")
    void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
