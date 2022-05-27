package edu.up.br.projeto_dev_software.controllers.controller_treinamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.up.br.projeto_dev_software.domain.domain_cadastro_funcionario.Funcionario;
import edu.up.br.projeto_dev_software.domain.domain_treinamento.Lista;
import edu.up.br.projeto_dev_software.domain.domain_treinamento.TreinamentoFuncionario;
import edu.up.br.projeto_dev_software.repository.FuncionarioRepository;
import edu.up.br.projeto_dev_software.repository.ListaRepository;


import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "treinamento")
@RestController
@RequestMapping("/treinamento")
public class ListaController {

    @Autowired
    private ListaRepository treinamentoRP;

    @Autowired
    private FuncionarioRepository funcionarioRP;

    @GetMapping("/listar")
    Iterable<Lista> listar() {
        System.out.println("Listar");
        return treinamentoRP.findAll();

    }

    @GetMapping("/listar/{id}")
    Lista buscarPorId(@PathVariable Long id) {
        return treinamentoRP.findById(id).get();
    }

    @PostMapping("/incluir")
    Lista incluir(@RequestBody Lista novaLista) {
        return treinamentoRP.save(novaLista);
    }
    
    @PutMapping("/atualizar/{id}")
    Lista atualizar(@RequestBody Lista listaAlterada, @PathVariable Long id) {
        return treinamentoRP.findById(id)
                .map(lista -> {
                    lista.setNomeTreinamento(listaAlterada.getNomeTreinamento());
                    return treinamentoRP.save(lista);
                })

                .orElseGet(() -> {
                    listaAlterada.setId(id);
                    return treinamentoRP.save(listaAlterada);
                });
    }

    @DeleteMapping("/deletar/{id}")
    void excluir(@PathVariable Long id) {
        treinamentoRP.deleteById(id);
    }

    //Parte de incluir um funcionario a um treinamento

    @PostMapping("/incluirFuncionario")
    Lista incluirFuncionario(@RequestBody TreinamentoFuncionario treinamentoFuncionario) {
        Lista treinamento = treinamentoRP.findById(treinamentoFuncionario.getId_treinamento()).get();
        Funcionario funcionario = funcionarioRP.findById(treinamentoFuncionario.getId_funcionario()).get();
        treinamento.getFuncionarios().add(funcionario);
        
        return treinamentoRP.save(treinamento);
    }

    //Parte de tirar um funcionario de um treinamento
    // @PostMapping("/removerFuncionario")
    // Lista removerFuncionario(@RequestBody TreinamentoFuncionario treinamentoFuncionario){
    //     Lista treinamento = treinamentoRP.findById(treinamentoFuncionario.getId_treinamento()).get();
    //    // treinamento.getFuncionarios()
    //     return treinamento;
    // }

}
