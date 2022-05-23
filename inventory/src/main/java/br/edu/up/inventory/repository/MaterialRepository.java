package br.edu.up.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.inventory.domain.Material;

public interface MaterialRepository extends CrudRepository<Material, Long> {

}
