package br.edu.up.produto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.produto.domain.Produto;
import br.edu.up.produto.repository.ProdutoRepository;

@RestController
public class ProdutoController {
    
    private final ProdutoRepository repository;

    ProdutoController(ProdutoRepository repository){
        this.repository = repository;
    }

    @GetMapping("/produtos")
    Iterable<Produto> listar(){
        return repository.findAll();
    }

    @GetMapping("/produtos/{id}")
    Produto buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/produtos")
    Produto incluir(@RequestBody Produto novoProduto){
        return repository.save(novoProduto);
    }


    @PutMapping("/produtos/{id}")
    Produto atualizar(@RequestBody Produto produtoAlterado, @PathVariable Long id){
        return repository.findById(id)
        .map(produto -> {
            produto.setNome(produtoAlterado.getNome());
            produto.setDescricao(produtoAlterado.getDescricao());
            produto.setQuantidade(produtoAlterado.getQuantidade());
            produto.setPreco(produtoAlterado.getPreco());
            return repository.save(produto);
        })
        .orElseGet(() -> {
            produtoAlterado.setId(id);
            return repository.save(produtoAlterado);
        });    
    }
    @DeleteMapping("/produtos/{id}")
    void excluir(@PathVariable("id") Produto id){
        repository.delete(id);
    }
}
