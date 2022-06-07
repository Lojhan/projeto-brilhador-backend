package br.edu.up.financial.lancamentos_contabeis.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.up.financial.lancamentos_contabeis.Domain.LancamentoCabecalho;
import br.edu.up.financial.lancamentos_contabeis.Domain.Movement;
import br.edu.up.financial.lancamentos_contabeis.Domain.MovementList;
import br.edu.up.financial.lancamentos_contabeis.repository.LancamentoCabecalhoRepository;
import br.edu.up.financial.lancamentos_contabeis.repository.LancamentoRepository;
import br.edu.up.financial.lancamentos_contabeis.Domain.Lancamento;

@RestController
public class LancamentoController {
    @Autowired
    private LancamentoRepository lancRepository;

    @Autowired
    private LancamentoCabecalhoRepository cabRepository;
    public final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


    @GetMapping("/cabecalhoLancamentos")
    Iterable<LancamentoCabecalho> listar(){
        return cabRepository.findAll();
    }

    @GetMapping("/cabecalhoLancamentos/{id}")
    LancamentoCabecalho buscarPorId(@PathVariable Long id){
        return cabRepository.findById(id).get();
    }

    @PostMapping("/cabecalhoLancamentos")
    LancamentoCabecalho incluir(@RequestBody LancamentoCabecalho novoCabecalho){
        return cabRepository.save(novoCabecalho);
    }


    @PutMapping("/cabecalhoLancamentos/{id}")
    LancamentoCabecalho atualizar(@RequestBody LancamentoCabecalho cabAlterado, @PathVariable Long id){
        return cabRepository.findById(id)
        .map(cabecalho -> {
            cabecalho.setDataLancamento(cabAlterado.getDataLancamento());
            cabecalho.setDocumento(cabAlterado.getDocumento());
            cabecalho.setTipoLancamento(cabAlterado.getTipoLancamento());
            cabecalho.setStatus(cabAlterado.getStatus());
            cabecalho.setFornecedor(cabAlterado.getFornecedor());
            cabecalho.setCliente(cabAlterado.getCliente());
            return cabRepository.save(cabecalho);
        })
        .orElseGet(() -> {
            cabAlterado.setId(id);
            return cabRepository.save(cabAlterado);
        });    
    }

    @DeleteMapping("/cabecalhoLancamentos/{id}")
    void excluir(@PathVariable Long id){
        cabRepository.deleteById(id);
    }

    @GetMapping("/cabecalhoLancamentos/divergentes")
    Iterable<LancamentoCabecalho> buscarLancamentosDivergentes(){
        Iterable<Lancamento> lancamentos = lancRepository.findAll();
        Iterable<LancamentoCabecalho> cabLancamentos = cabRepository.findAll();
        List<Long> listaTemp = new ArrayList<Long>();
        double somaCredito = 0;
        double somaDebito = 0;
        for (LancamentoCabecalho cabLancamento : cabLancamentos) {
            somaCredito = 0;
            somaDebito = 0;
            for (Lancamento lancamento : lancamentos) {
                if (cabLancamento.getId() == lancamento.getCabLancamento().getId()){
                    somaCredito = somaCredito + lancamento.getValorCredito();
                    somaDebito  = somaDebito + lancamento.getValorDebito();       
                }
            }
            if (somaCredito != somaDebito){
                listaTemp.add(cabLancamento.getId());
            }
 
        }
       
        Iterable<Long> idsIterable = listaTemp;
        return cabRepository.findAllById(idsIterable);
    }

    @GetMapping("/cabecalhoLancamentos/gerarLancamentosEstoqueData")
    Iterable<LancamentoCabecalho> gerarLancamentosEstoqueData(@RequestParam(value = "data", required = true) @DateTimeFormat(pattern="ddMMyyyy") Date datinha) throws ParseException{
        RestTemplate restTemplate;  
        
        restTemplate = new RestTemplate();

        ResponseEntity<List<Movement>> responseEntity = 
        restTemplate.exchange(
            "http://inventory-brilhador/movement",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Movement>>() {}
        );
        List<Movement> movements = responseEntity.getBody();

        for (Movement movement : movements) {
              
            String dataMovimento = formatter.format(movement.getDateTime());        
            String dataLanc = formatter.format(datinha);
            if(dataMovimento.equals(dataLanc)){
                LancamentoCabecalho cabAux = new LancamentoCabecalho(datinha,"ES",dataMovimento+"- Data DAtinha "+dataLanc+" Lançamento Referente ao Produto"+movement.getName()+"de id "+(String.valueOf(movement.getId())));
                cabRepository.save(cabAux); 
                lancRepository.save(new Lancamento(cabAux,250,"Conta de Estoque",0,movement.getTotalPrice()));
                lancRepository.save(new Lancamento(cabAux,200,"Conta de Resultado",movement.getTotalPrice(),0));
            }
        }
        return cabRepository.findAll();
    }
}
