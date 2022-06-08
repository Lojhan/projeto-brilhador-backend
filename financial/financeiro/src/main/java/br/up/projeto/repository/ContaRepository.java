package br.up.projeto.repository;

import br.up.projeto.domain.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Long> {
    
}
