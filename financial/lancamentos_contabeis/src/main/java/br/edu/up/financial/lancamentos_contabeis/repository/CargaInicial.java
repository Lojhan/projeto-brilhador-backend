package br.edu.up.financial.lancamentos_contabeis.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.up.financial.lancamentos_contabeis.Domain.Lancamento;
import br.edu.up.financial.lancamentos_contabeis.Domain.LancamentoCabecalho;

@Configuration
public class CargaInicial {

    public CargaInicial() throws Exception{
    }

    private static final Logger log = LoggerFactory.getLogger(CargaInicial.class);

    private  LancamentoCabecalho cablancamento = new LancamentoCabecalho(new SimpleDateFormat("dd/MM/yyyy").parse("04/04/2022"),"LM","TesteFilhos");
    private  LancamentoCabecalho cablancamentoDivergente = new LancamentoCabecalho(new SimpleDateFormat("dd/MM/yyyy").parse("05/04/2022"),"LM","TesteFilhosDivergentesx");
    @Bean CommandLineRunner
    iniciarDb(LancamentoCabecalhoRepository repository, LancamentoRepository repositoryFilho){
        return args -> {
            log.info("Carregando..."+ repository.save(new LancamentoCabecalho(new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2022"),"LM","JovemParceiro")));
            log.info("Carregando..."+ repository.save(new LancamentoCabecalho(new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2022"),"LM","JovemParceiro")));
            log.info("Carregando..."+ repository.save(cablancamento));
            log.info("Carregando..."+ repositoryFilho.save(new Lancamento(cablancamento,250,"ContaTeste1",300,0)));
            log.info("Carregando..."+ repositoryFilho.save(new Lancamento(cablancamento,200,"ContaTeste2",0,300)));
            log.info("Carregando..."+ repository.save(cablancamentoDivergente));
            log.info("Carregando..."+ repositoryFilho.save(new Lancamento(cablancamentoDivergente,300,"ContaTeste1",650,0)));
            log.info("Carregando..."+ repositoryFilho.save(new Lancamento(cablancamentoDivergente,400,"ContaTeste2",0,400)));
        };
    }

    
}
