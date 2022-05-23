package br.edu.up.inventory.domain;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private long id;

    private int validade;
    private String nome;
    private int quantidade;
    private String unidade;

    @Column(name = "id_setor")
    private long idSetor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_setor", updatable = false, insertable = false)
    private Setor setor;

    public Produto() { 

    }

    public Produto(int validade, String nome, int quantidade, String unidade){
        this.validade = validade;
        this.nome= nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public void atualizarProduto(Produto produtoAlterado) {
        this.nome = produtoAlterado.getNome();
        this.validade = produtoAlterado.getValidade();
        this.quantidade = produtoAlterado.getQuantidade();
        this.unidade = produtoAlterado.getUnidade();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public int getQuantidade() {
    return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(long idSetor) {
        this.idSetor = idSetor;
    }
}
 
