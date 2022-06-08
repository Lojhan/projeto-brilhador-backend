package br.edu.up.planocontas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.planocontas.domain.Usuario;
import br.edu.up.planocontas.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  private final UsuarioRepository repository;

  public UsuarioController(UsuarioRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/listarTodos")
  public ResponseEntity<List<Usuario>> listarTodos() {
    return ResponseEntity.ok(repository.findAll());
  }
}
