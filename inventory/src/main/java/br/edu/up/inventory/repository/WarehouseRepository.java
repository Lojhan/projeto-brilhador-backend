package br.edu.up.inventory.repository;

import br.edu.up.inventory.domain.Warehouse;
import org.springframework.data.repository.CrudRepository;

public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {

}
