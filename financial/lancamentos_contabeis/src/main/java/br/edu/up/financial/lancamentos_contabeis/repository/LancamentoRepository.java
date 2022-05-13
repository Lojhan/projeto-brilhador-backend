package br.edu.up.financial.lancamentos_contabeis.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.financial.lancamentos_contabeis.Domain.Lancamento;
import br.edu.up.financial.lancamentos_contabeis.Domain.LancamentoCabecalho;

import java.util.List;

public interface LancamentoRepository extends CrudRepository<Lancamento, Long> {
  List<Lancamento> findBycabLancamento(LancamentoCabecalho cabLancamento);
}
