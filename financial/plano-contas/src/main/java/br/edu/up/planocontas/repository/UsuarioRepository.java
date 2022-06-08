package br.edu.up.planocontas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.up.planocontas.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  public Optional<Usuario> findByLogin(String login);
}
