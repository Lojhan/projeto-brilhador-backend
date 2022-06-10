package br.edu.up.produto.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.produto.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    
}
