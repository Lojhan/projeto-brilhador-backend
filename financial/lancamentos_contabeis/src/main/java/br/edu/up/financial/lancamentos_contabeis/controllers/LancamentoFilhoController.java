package br.edu.up.financial.lancamentos_contabeis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.financial.lancamentos_contabeis.Domain.Lancamento;
import br.edu.up.financial.lancamentos_contabeis.repository.LancamentoCabecalhoRepository;
import br.edu.up.financial.lancamentos_contabeis.repository.LancamentoRepository;

@RestController
public class LancamentoFilhoController {
    @Autowired
    private LancamentoRepository lancRepository;

    @Autowired
    private LancamentoCabecalhoRepository cabRepository;

    @GetMapping("/cabecalhoLancamentos/{id}/lancamentos")
    Iterable<Lancamento> listar(@PathVariable Long id){

        List<Lancamento> lancamentos = lancRepository.findBycabLancamento(cabRepository.findById(id).get());

        return lancamentos;
    }    

    @GetMapping("/cabecalhoLancamentos/{id_Pai}/lancamentos/{id_Filho}")
    Lancamento buscarPorId(@PathVariable Long id_Pai,@PathVariable Long id_Filho){
        return lancRepository.findById(id_Filho).get();
    }

    @PostMapping("/cabecalhoLancamentos/{id_Pai}/lancamentos/")
    Lancamento incluir(@PathVariable Long id_Pai,@RequestBody Lancamento novoLancamento){
        return lancRepository.save(novoLancamento);
    }


    @PutMapping("/cabecalhoLancamentos/{id_Pai}/lancamentos/{id_filho}")
    Lancamento atualizar(@PathVariable Long id_Pai,@RequestBody Lancamento lancAlterado, @PathVariable Long id_filho){
        return lancRepository.findById(id_filho)
        .map(lancamento -> {
            lancamento.setIdContaContabil(lancAlterado.getIdContaContabil());
            lancamento.setNomeContaContabil(lancAlterado.getNomeContaContabil());
            lancamento.setValorDebito(lancAlterado.getValorDebito());
            lancamento.setValorCredito(lancAlterado.getValorCredito());
            return lancRepository.save(lancamento);
        })
        .orElseGet(() -> {
            lancAlterado.setId(id_filho);
            return lancRepository.save(lancAlterado);
        });    
    }

    @DeleteMapping("/cabecalhoLancamentos/{id_Pai}/lancamentos/{id_Filho}")
    void excluir(@PathVariable Long id_Pai,@PathVariable Long id_Filho){
        lancRepository.deleteById(id_Filho);
    }


}
