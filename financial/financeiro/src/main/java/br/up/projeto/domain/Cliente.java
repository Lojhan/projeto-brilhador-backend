package br.up.projeto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cpf;
    private String datanasc;
    private String email;
    private String senha;

    // Constructor
    public Cliente() {
    }

    public Cliente(String nome, String cpf, String datanasc, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.datanasc = datanasc;
        this.email = email;
        this.senha = senha;
    }

    public Cliente(Long id, String nome, String cpf, String datanasc, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.datanasc = datanasc;
        this.email = email;
        this.senha = senha;
    }

    // GET
    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public String getCPF() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getDatanasc() {
        return datanasc;
    }

    // SET
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

}
