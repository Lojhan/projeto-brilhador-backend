package edu.up.br.projeto_dev_software.repository;

import edu.up.br.projeto_dev_software.domain.domain_plano_saude.PlanoSaude;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoSaudeRepository extends JpaRepository<PlanoSaude, Long> {


}

// Estrutura e exemplos lista de treinamento para json server:
  // ID: 1
  // Nome do plano: Plano de saúde - premium 
  // Valor do plano: 87
  // Area (FK vindo da classe Funcionario): "Funcionario"

// Estrutura e exemplos lista de treinamento para json server:
  // ID: 2
  // Nome do plano: Plano de saúde - basic 
  // Valor do plano: 35
  // Area (FK vindo da classe Funcionario): "Funcionario"
