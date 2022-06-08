package br.up.projeto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class LancamentoValor  {
    
    @Id
    @GeneratedValue
    private Long id;
    private String data;
    private Double valor;
    private int cliente;
    private  int conta;
    private int meioPagamento;


    public LancamentoValor(String data, Double valor, int i, int j, int k) {
        this.data = data;
        this.valor = valor;
        this.cliente = i;
        this.conta = j;
        this.meioPagamento = k;
    }
    public LancamentoValor(Long id, String data, Double valor, int cliente, int conta, int meioPagamento) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.conta = conta;
        this.meioPagamento = meioPagamento;
    }
    public LancamentoValor() {
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    public int getCliente() {
        return cliente;
    }

    public int getConta() {
        return conta;
    }

    public int getMeioPagamento() {
        return meioPagamento;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public void setMeioPagamento(int meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

}