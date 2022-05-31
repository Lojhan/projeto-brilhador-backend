package br.edu.up.inventory.repository;

import br.edu.up.inventory.domain.Movement;
import org.springframework.data.repository.CrudRepository;

public interface MovementRepository extends CrudRepository<Movement, Long> {

}
