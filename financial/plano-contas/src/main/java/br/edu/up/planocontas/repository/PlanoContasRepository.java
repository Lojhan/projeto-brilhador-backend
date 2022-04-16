package br.edu.up.planocontas.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.planocontas.domain.PlanoContas;

public interface PlanoContasRepository extends CrudRepository<PlanoContas, Long> {

}
