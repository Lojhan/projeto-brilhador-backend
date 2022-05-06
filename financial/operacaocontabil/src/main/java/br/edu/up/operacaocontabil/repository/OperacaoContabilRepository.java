package br.edu.up.operacaocontabil.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.operacaocontabil.domain.OperacaoContabil;

public interface OperacaoContabilRepository extends CrudRepository<OperacaoContabil, Long>{
    
}
