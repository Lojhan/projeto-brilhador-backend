package br.edu.up.inventory.repository;

import br.edu.up.inventory.domain.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}