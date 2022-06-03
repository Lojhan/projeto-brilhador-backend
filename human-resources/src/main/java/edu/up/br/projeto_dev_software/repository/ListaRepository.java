package edu.up.br.projeto_dev_software.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.up.br.projeto_dev_software.domain.domain_treinamento.Lista;



public interface ListaRepository extends JpaRepository<Lista, Long> {
    
}
