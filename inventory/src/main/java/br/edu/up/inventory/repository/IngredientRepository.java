package br.edu.up.inventory.repository;

import br.edu.up.inventory.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
