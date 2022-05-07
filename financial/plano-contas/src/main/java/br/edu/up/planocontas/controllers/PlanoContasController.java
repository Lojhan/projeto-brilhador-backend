package br.edu.up.planocontas.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.planocontas.domain.PlanoContas;
import br.edu.up.planocontas.repository.PlanoContasRepository;

@RestController
public class PlanoContasController {

  private final PlanoContasRepository repository;

  PlanoContasController(PlanoContasRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/planocontas")
  Iterable<PlanoContas> listar() {
    return repository.findAll();
  }

  @GetMapping("/planocontas/{id}")
  PlanoContas buscarPorId(@PathVariable Long id) {
    return repository.findById(id).get();
  }

  @PostMapping("/planocontas")
  PlanoContas incluir(@RequestBody PlanoContas novoPlanoContas) {
    return repository.save(novoPlanoContas);
  }

  @PutMapping("/planocontas/{id}")
  PlanoContas atualizar(@RequestBody PlanoContas planoContasAlterado, @PathVariable Long id) {
    return repository.findById(id)
        .map(planoContas -> {
          planoContas.setNome(planoContasAlterado.getNome());
          return repository.save(planoContas);
        })
        .orElseGet(() -> {
          planoContasAlterado.setId(id);
          return repository.save(planoContasAlterado);
        });
  }

  @DeleteMapping("/planocontas/{id}")
  void excluir(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
