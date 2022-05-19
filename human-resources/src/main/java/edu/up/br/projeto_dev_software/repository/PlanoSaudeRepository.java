package edu.up.br.projeto_dev_software.repository;

import edu.up.br.projeto_dev_software.domain.domain_plano_saude.PlanoSaude;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoSaudeRepository extends JpaRepository<PlanoSaude, Long> {
    
}