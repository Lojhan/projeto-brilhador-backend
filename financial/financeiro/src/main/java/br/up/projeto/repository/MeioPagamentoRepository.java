package br.up.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import br.up.projeto.domain.MeioPagamento;

public interface MeioPagamentoRepository extends CrudRepository<MeioPagamento, Long> {

}
