package edu.up.br.projeto_dev_software.controllers.controller_relacionamento_cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.up.br.projeto_dev_software.domain.domain_cadastro_funcionario.Funcionario;
import edu.up.br.projeto_dev_software.domain.domain_relacionamento_cliente.RelCliente;
import edu.up.br.projeto_dev_software.repository.FuncionarioRepository;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "relCliente")
@RestController
@RequestMapping("/relCliente")
public class ControllerRelCliente {

    @Autowired
    private FuncionarioRepository funcionarioRP;

    @GetMapping("/listar")
    List<RelCliente> listar() {
        List<RelCliente> listaCliente = new ArrayList<>();
        List<Funcionario> listaFuncionarios = funcionarioRP.findAll();

        for (Funcionario f : listaFuncionarios) {
            RelCliente cliente = new RelCliente();
            cliente.setNomeFuncionario(f.getNome());
            cliente.setArea(f.getArea());
            cliente.setDescricao(f.getDescricao());
            cliente.setStatus(f.getStatus());
            listaCliente.add(cliente);
        }
        return listaCliente;
    }

    @PostMapping("/listar/{id}")
    RelCliente listarPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRP.getById(id);
        RelCliente cliente = new RelCliente();
        cliente.setNomeFuncionario(funcionario.getNome());
        cliente.setArea(funcionario.getArea());
        cliente.setDescricao(funcionario.getDescricao());
        cliente.setStatus(funcionario.getStatus());
        return cliente;
    }

}
