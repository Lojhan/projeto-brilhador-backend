package br.edu.up.pessoa.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.pessoa.domain.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
    
}
