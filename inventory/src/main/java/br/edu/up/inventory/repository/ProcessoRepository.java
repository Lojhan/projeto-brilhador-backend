package br.edu.up.inventory.repository;

import br.edu.up.inventory.domain.Processo;
import org.springframework.data.repository.CrudRepository;

public interface ProcessoRepository extends CrudRepository<Processo, Long> {
}
