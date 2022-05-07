package br.edu.up.patrimonial.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patrimonial {
    

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Double valor;
    private Double creditoPis;
    private Double creditoCofins;
    private Date dataEntrada;
    private Date dataSaida;

    public Patrimonial() {
    }

    public Patrimonial(String nome) {
        this.nome = nome;
    }
    public Patrimonial(Long id, String nome) {
        this.nome = nome;
        this.id = id;
    }

    public Patrimonial(String nome, double valor, double creditoPis, double creditoCofins, Date dataEntrada, Date dataSaida) {
        this.nome = nome;
        this.valor = valor;
        this.creditoCofins = creditoCofins;
        this.creditoPis = creditoPis;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Patrimonial(String nome, double valor, double creditoPis, double creditoCofins, Date dataEntrada) {
        this.nome = nome;
        this.valor = valor;
        this.creditoCofins = creditoCofins;
        this.creditoPis = creditoPis;
        this.dataEntrada = dataEntrada;
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
    public Date getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    public Date getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public Double getCreditoCofins() {
        return creditoCofins;
    }
    public void setCreditoCofins(Double creditoCofins) {
        this.creditoCofins = creditoCofins;
    }
    public Double getCreditoPis() {
        return creditoPis;
    }
    public void setCreditoPis(Double creditoPis) {
        this.creditoPis = creditoPis;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
     

}
