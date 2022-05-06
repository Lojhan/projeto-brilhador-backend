package br.edu.up.patrimonial.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.patrimonial.domain.Patrimonial;

public interface PatrimonialRepository extends CrudRepository<Patrimonial, Long> {
    
}
