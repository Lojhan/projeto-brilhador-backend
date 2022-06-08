package br.up.projeto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.up.projeto.domain.Cliente;
import br.up.projeto.repository.ClienteRepository;

@RestController
public class ClienteController {

    private final ClienteRepository repository;

    ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cliente")
    Iterable<Cliente> lsitar() {
        return repository.findAll();
    }

    @GetMapping("cliente/{id}")
    Cliente buscarPorId(@PathVariable long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/cliente")
    Cliente incluir(@RequestBody Cliente novoCliente) {
        return repository.save(novoCliente);
    }

    @PutMapping("/cliente/{id}")
    Cliente atualizar(@RequestBody Cliente clienteAlterado, @PathVariable Long id) {
        return repository.findById(id).map(cliente -> {
            cliente.setNome(clienteAlterado.getNome());
            cliente.setCPF(clienteAlterado.getCPF());
            cliente.setDatanasc(clienteAlterado.getDatanasc());
            cliente.setEmail(clienteAlterado.getEmail());
            cliente.setSenha(clienteAlterado.getSenha());
            return repository.save(cliente);
        })
        .orElseGet(() -> {
            clienteAlterado.setId(id);
            return repository.save(clienteAlterado);
        });
    }

    @DeleteMapping("/cliente/{id}")
    void excluir(@PathVariable long id) {
        repository.deleteById(id);
    }
}
