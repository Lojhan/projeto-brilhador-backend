package br.edu.up.inventory.repository;

import br.edu.up.inventory.domain.Process;
import org.springframework.data.repository.CrudRepository;

public interface ProcessRepository extends CrudRepository<Process, Long> {
}
