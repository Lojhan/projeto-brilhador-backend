package br.edu.up.pessoa.venda.repository;

import br.edu.up.pessoa.venda.domain.Venda;
import org.springframework.data.repository.CrudRepository;

public interface VendaRepository extends CrudRepository<Venda, Long> {
    
}
