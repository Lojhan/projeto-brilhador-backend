package br.edu.up.planocontas.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.up.planocontas.domain.PlanoContas;

@Configuration
public class CargaInicial {

  private static final Logger log = LoggerFactory.getLogger(CargaInicial.class);

  @Bean
  CommandLineRunner iniciarDb(PlanoContasRepository repository) {
    return args -> {
      log.info("Carregando..." + repository.save(new PlanoContas("Ativo", "Credito", "Patrimonial")));
      log.info("Carregando..." + repository.save(new PlanoContas("Passivo", "Débito", "Patrimonial")));
      log.info("Carregando..." + repository.save(new PlanoContas("Receita", "Crédito", "Resultado")));
      log.info("Carregando..." + repository.save(new PlanoContas("Despesa", "Dédito", "Resultado")));
    };
  }

}
