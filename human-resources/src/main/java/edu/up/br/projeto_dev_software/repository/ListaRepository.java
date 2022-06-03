package edu.up.br.projeto_dev_software.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.up.br.projeto_dev_software.domain.domain_treinamento.Lista;



public interface ListaRepository extends JpaRepository<Lista, Long> {
    
}

  // Estrutura e exemplos lista de treinamento para json server:
  // ID: 1
  // Nome Treinamento: Treinamento funcionarios do setor de Estoque
  // Area (FK vindo da classe Funcionario): "Estoque"

  // ID: 2
  // Nome Treinamento: Treinamento funcionarios do setor Financeiro
  // Area (FK vindo da classe Funcionario): "Financeiro"