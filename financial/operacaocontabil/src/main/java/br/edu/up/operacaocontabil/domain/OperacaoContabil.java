package br.edu.up.operacaocontabil.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OperacaoContabil {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private String codigo;
    private int cfop;

    public OperacaoContabil(){

    }
    public OperacaoContabil(String descricao){
        this.descricao = descricao;
    }

    public OperacaoContabil(String descricao, String codigo, int cfop) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.cfop = cfop;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getCfop(){
        return cfop;
    }
    public void setCfop(int cfop){
        this.cfop = cfop;
    }
}
