package br.edu.up.produto.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.edu.up.produto.domain.Produto;

@Component
public class CargaInicialProduto {

    private static final Logger log = LoggerFactory.getLogger(CargaInicialProduto.class);
  

    @Bean CommandLineRunner
    iniciarDbProdutos(ProdutoRepository repository){
        return args -> {
            log.info("Carregando..." + repository.save(new Produto("Triplex com Suíte", "Triplex com suíte, 3 banheiros e lavabo no centro", 2, 3800000)));
            log.info("Carregando..." + repository.save(new Produto("Apartamento loft", "Apartamento de 2 quartos e 1 banheiro", 2, 3500000)));
        };
    }
    
}
