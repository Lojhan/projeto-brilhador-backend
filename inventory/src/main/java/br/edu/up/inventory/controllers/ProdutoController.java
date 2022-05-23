package br.edu.up.inventory.controllers;

import br.edu.up.inventory.domain.Produto;
import br.edu.up.inventory.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoRepository repository;

    ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Produto> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Produto buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping()
    Produto incluir(@RequestBody Produto novoProduto) {
        return repository.save(novoProduto);
    }

    @PutMapping("/{id}")
    Produto atualizar(@RequestBody Produto produtoAlterado, @PathVariable Long id) {
        return repository.findById(id)
                .map(produto -> {
                    // id encontrado
                    produto.atualizarProduto(produtoAlterado);
                    return repository.save(produto);
                })
                .orElseGet(() -> {
                    // id não encontrado
                    produtoAlterado.setId(id);
                    return repository.save(produtoAlterado);
                });
    }

    @DeleteMapping("/{id}")
    void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
