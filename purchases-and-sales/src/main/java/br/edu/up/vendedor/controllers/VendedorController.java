package br.edu.up.vendedor.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.vendedor.domain.Vendedor;
import br.edu.up.vendedor.repository.VendedorRepository;

@RestController
public class VendedorController {
    
    private final VendedorRepository repository;

    VendedorController(VendedorRepository repository){
        this.repository = repository;
    }

    @GetMapping("/vendedores")
    Iterable<Vendedor> listar(){
        return repository.findAll();
    }

    @GetMapping("/vendedores/{id}")
    Vendedor buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/vendedores")
    Vendedor incluir(@RequestBody Vendedor novoVendedor){
        return repository.save(novoVendedor);
    }


    @PutMapping("/vendedores/{id}")
    Vendedor atualizar(@RequestBody Vendedor vendedorAlterado, @PathVariable Long id){
        return repository.findById(id)
        .map(vendedor -> {
            vendedor.setNome(vendedorAlterado.getNome());
            vendedor.setComissao(vendedorAlterado.getComissao());
            return repository.save(vendedor);
        })
        .orElseGet(() -> {
            vendedorAlterado.setId(id);
            return repository.save(vendedorAlterado);
        });    
    }
    @DeleteMapping("/vendedores/{id}")
    void excluir(@PathVariable("id") Vendedor id){
        repository.delete(id);
    }
}
