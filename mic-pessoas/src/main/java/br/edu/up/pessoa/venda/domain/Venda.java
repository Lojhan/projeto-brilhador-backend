package br.edu.up.pessoa.venda.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;

import br.edu.up.vendedor.domain.Vendedor;
import br.edu.up.pessoa.domain.Pessoa;
import br.edu.up.produto.domain.Produto;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="vendedor_id")
    private Vendedor vendedor;
    
    @ManyToOne
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;
    
    private double quantidade;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    

  

    public Venda() {
    }

    public Venda(Vendedor vendedor, Pessoa pessoa, double quantidade, Produto produto) {
        this.vendedor = vendedor;
        this.pessoa = pessoa;
        this.quantidade = quantidade;
        this.produto = produto;
    }

  

   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
