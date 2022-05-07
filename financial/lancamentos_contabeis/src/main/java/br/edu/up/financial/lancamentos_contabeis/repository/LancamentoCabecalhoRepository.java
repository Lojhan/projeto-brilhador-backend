package br.edu.up.financial.lancamentos_contabeis.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.financial.lancamentos_contabeis.Domain.LancamentoCabecalho;

public interface LancamentoCabecalhoRepository extends CrudRepository<LancamentoCabecalho,Long> {
    
}
