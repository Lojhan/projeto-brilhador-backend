package br.edu.up.financial.lancamentos_contabeis.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LANCAMENTOS")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false,unique = true,updatable = false)
    private long id;
    @Column(name = "ID_CONTA_CONTABIL", nullable = false,updatable = false)
    private long idContaContabil;
    @Column(name = "NOME_CONTA_CONTABIL", nullable = false,updatable = false)
    private String nomeContaContabil;
    @Column(name = "VALOR_CREDITO")
    private double valorCredito;
    @Column(name = "VALOR_DEBITO")
    private double valorDebito;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LancamentoCabecalho_id", nullable = false)
    private LancamentoCabecalho cabLancamento;



    public Lancamento(long id, LancamentoCabecalho cabLancamento, long idContaContabil, String nomeContaContabil,
    double valorCredito) {
    this.id = id;
    this.cabLancamento = cabLancamento;
    this.idContaContabil = idContaContabil;
    this.nomeContaContabil = nomeContaContabil;
    this.valorCredito = valorCredito;
    }
    public Lancamento(long id, LancamentoCabecalho cabLancamento, long idContaContabil, String nomeContaContabil) {
    this.id = id;
    this.cabLancamento = cabLancamento;
    this.idContaContabil = idContaContabil;
    this.nomeContaContabil = nomeContaContabil;
    }
    public Lancamento() {
    }
    public Lancamento(long id, LancamentoCabecalho cabLancamento, long idContaContabil, String nomeContaContabil,
        double valorCredito, double valorDebito) {
    this.id = id;
    this.cabLancamento = cabLancamento;
    this.idContaContabil = idContaContabil;
    this.nomeContaContabil = nomeContaContabil;
    this.valorCredito = valorCredito;
    this.valorDebito = valorDebito;
    }

    public Lancamento(LancamentoCabecalho cabLancamento, long idContaContabil, String nomeContaContabil, double valorCredito,
    double valorDebito) {
    this.cabLancamento = cabLancamento;
    this.idContaContabil = idContaContabil;
    this.nomeContaContabil = nomeContaContabil;
    this.valorCredito = valorCredito;
    this.valorDebito = valorDebito;
    }

    public long getIdContaContabil() {
        return idContaContabil;
    }
    public double getValorDebito() {
        return valorDebito;
    }
    public void setValorDebito(double valorDebito) {
        this.valorDebito = valorDebito;
    }
    public double getValorCredito() {
        return valorCredito;
    }
    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }
    public String getNomeContaContabil() {
        return nomeContaContabil;
    }
    public void setNomeContaContabil(String nomeContaContabil) {
        this.nomeContaContabil = nomeContaContabil;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setIdContaContabil(long idContaContabil) {
        this.idContaContabil = idContaContabil;
    }
    public LancamentoCabecalho getCabLancamento() {
        return cabLancamento;
    }
    public void setCabLancamento(LancamentoCabecalho cabLancamento) {
        this.cabLancamento = cabLancamento;
    }
    
}
