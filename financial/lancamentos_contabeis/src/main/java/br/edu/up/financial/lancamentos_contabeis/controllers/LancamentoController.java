package br.edu.up.financial.lancamentos_contabeis.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.financial.lancamentos_contabeis.Domain.LancamentoCabecalho;
import br.edu.up.financial.lancamentos_contabeis.repository.LancamentoCabecalhoRepository;
import br.edu.up.financial.lancamentos_contabeis.repository.LancamentoRepository;
import br.edu.up.financial.lancamentos_contabeis.Domain.Lancamento;

@RestController
public class LancamentoController {
    @Autowired
    private LancamentoRepository lancRepository;

    @Autowired
    private LancamentoCabecalhoRepository cabRepository;
    
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
    
}
