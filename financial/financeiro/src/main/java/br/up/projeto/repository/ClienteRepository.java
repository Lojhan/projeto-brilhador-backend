package br.up.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import br.up.projeto.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
