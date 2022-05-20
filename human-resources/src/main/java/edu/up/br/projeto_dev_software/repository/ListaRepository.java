package edu.up.br.projeto_dev_software.repository;
import org.springframework.data.repository.CrudRepository;
import edu.up.br.projeto_dev_software.domain.domain_treinamento.Lista;



public interface ListaRepository extends CrudRepository<Lista, Long> {
    
}
