package edu.up.br.projeto_dev_software.controllers.controller_cadastro_funcionario;

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
import edu.up.br.projeto_dev_software.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    // Iniciando PessoaRepository
    @Autowired
    private FuncionarioRepository repository;

    // Criando Chamadas
    // =========================================================================

    // Incluindo novo funcionario
    @PostMapping("/incluir")
    Funcionario incluir(@RequestBody Funcionario novoFuncionario) {
        return repository.save(novoFuncionario);
    }

    // Alterar funcionario
    // ==============================================================
    @PutMapping("/alterar/{id}")
    Funcionario atualizar(@RequestBody Funcionario funcionarioAlterado, @PathVariable Long id) {
        return repository.findById(id)
                .map(funcionario -> {
                    funcionario.setNome(funcionarioAlterado.getNome());
                    funcionario.setEmail(funcionarioAlterado.getEmail());
                    funcionario.setDataNasc(funcionarioAlterado.getDataNasc());
                    funcionario.setCpf(funcionarioAlterado.getCpf());
                    funcionario.setSalario(funcionarioAlterado.getSalario());
                    funcionario.setDescricao(funcionarioAlterado.getDescricao());
                    funcionario.setTrans(funcionarioAlterado.getTrans());
                    funcionario.setDataContr(funcionarioAlterado.getDataContr());
                    funcionario.setPlanoSaude(funcionarioAlterado.getPlanoSaude());
                    return repository.save(funcionario);
                })
                .orElseGet(() -> {
                    funcionarioAlterado.setId(id);
                    return repository.save(funcionarioAlterado);
                });

    }

    // Listar todos os funcionarios
    // ==============================================================
    @GetMapping("/listar")
    Iterable<Funcionario> listar() {
        return repository.findAll();
    }

    // Listar todos os funcionario com mesmo cpf //Fazer uma para treinamento
    // buscado por função
    // @GetMapping("/funcionario/{cpf}")
    // ResponseEntity<List<Funcionario>> getFuncionarioCpf(@PathVariable String cpf) {
    //     return new ResponseEntity<List<Funcionario>>(repository.findByCpf(cpf), HttpStatus.OK);
    // }

    // Deletar funcionario
    @DeleteMapping("/deletar/{id}")
    void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
