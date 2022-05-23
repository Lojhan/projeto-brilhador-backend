package br.edu.up.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Processo {

    @Id
    @GeneratedValue
    private long id;

    private String nome;
    private String descricao;

    public Processo() {

    }

    public Processo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void atualizarProcesso(Processo processoAlterado) {
        this.nome = processoAlterado.getNome();
        this.descricao = processoAlterado.getDescricao();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
