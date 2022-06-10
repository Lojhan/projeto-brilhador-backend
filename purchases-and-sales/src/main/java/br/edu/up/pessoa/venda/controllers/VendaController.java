package br.edu.up.pessoa.venda.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.pessoa.venda.domain.Venda;
import br.edu.up.pessoa.venda.repository.VendaRepository;

@RestController
public class VendaController {
    
    private final VendaRepository repository;

    VendaController(VendaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/vendas")
    Iterable<Venda> listar(){
        return repository.findAll();
    }

    @GetMapping("/vendas/{id}")
    Venda buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/vendas")
    public String incluir(@RequestBody Venda novaVenda){
        
        if(novaVenda.getProduto().getQuantidade() > novaVenda.getQuantidade() ){
            return "Erro no processamento da venda! Quantidade requerida excedida!";
        }
        repository.save(novaVenda);
        return "Venda realizada com sucesso!";
    }


    @PutMapping("/vendas/{id}")
    Venda atualizar(@RequestBody Venda vendaAlterado, @PathVariable Long id){
        return repository.findById(id)
        .map(venda -> {
            venda.setVendedor(vendaAlterado.getVendedor());
            venda.setPessoa(vendaAlterado.getPessoa());
            venda.setProduto(vendaAlterado.getProduto());
            venda.setQuantidade(vendaAlterado.getQuantidade());
            return repository.save(venda);
        })
        .orElseGet(() -> {
            vendaAlterado.setId(id);
            return repository.save(vendaAlterado);
        });    
    }
    @DeleteMapping("/vendas/{id}")
    void excluir(@PathVariable("id") Venda id){
        repository.delete(id);
    }
}
