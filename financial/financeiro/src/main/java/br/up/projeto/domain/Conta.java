package br.up.projeto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {

    @Id
    @GeneratedValue
    private Long id;
    private String banco;
    private String agencia;
    private int codigo;
    private String nome;

    public Conta() {
    }

    public Conta(String nome, String banco, String agencia, int codigo) {
        this.banco = banco;
        this.agencia = agencia;
        this.codigo = codigo;
        this.nome = nome;
    }

    public Conta(Long id, String nome, String banco, String agencia, int codigo) {
        this.id = id;
        this.banco = banco;
        this.agencia = agencia;
        this.codigo = codigo;
        this.nome = nome;
    }

    
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
