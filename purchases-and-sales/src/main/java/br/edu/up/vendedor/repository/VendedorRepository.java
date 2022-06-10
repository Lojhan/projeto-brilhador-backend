package br.edu.up.vendedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.vendedor.domain.Vendedor;

public interface VendedorRepository extends CrudRepository<Vendedor, Long> {
    
}
