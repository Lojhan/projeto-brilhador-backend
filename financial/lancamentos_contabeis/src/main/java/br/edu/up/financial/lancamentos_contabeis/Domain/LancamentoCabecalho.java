package br.edu.up.financial.lancamentos_contabeis.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CAB_LANCAMENTOS")
public class LancamentoCabecalho {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false,unique = true,updatable = false)
    private long id;
   
    @Column(name = "DT_LANC", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Column(name = "TIPO",nullable = false,length = 2)
    private String tipoLancamento;
    @Column(name = "DOCUMENTO")
    private String documento;
    @Column(name = "FORNECEDOR")
    private String fornecedor;
    @Column(name = "CLIENTE")
    private String cliente;
    @Column(name = "STATUS")
    private String status;


    @OneToMany(mappedBy = "cabLancamento", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Lancamento> lancamentos;

    //constructors
    public LancamentoCabecalho(long id, Date dataLancamento, String tipoLancamento, String documento, String fornecedor,
        String cliente, String status) {
    this.id = id;
    this.dataLancamento = dataLancamento;
    this.tipoLancamento = tipoLancamento;
    this.documento = documento;
    this.fornecedor = fornecedor;
    this.cliente = cliente;
    this.status = status;
    }

    public LancamentoCabecalho(Date dataLancamento, String tipoLancamento, String documento, String fornecedor,
        String cliente, String status) {
    this.dataLancamento = dataLancamento;
    this.tipoLancamento = tipoLancamento;
    this.documento = documento;
    this.fornecedor = fornecedor;
    this.cliente = cliente;
    this.status = status;
    }

    
    public LancamentoCabecalho() {
    }

    public LancamentoCabecalho(Date dataLancamento, String tipoLancamento, String documento) {
        this.dataLancamento = dataLancamento;
        this.tipoLancamento = tipoLancamento;
        this.documento = documento;
    }



    public long getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getTipoLancamento() {
        return tipoLancamento;
    }
    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }
    public Date getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public void setId(long id) {
        this.id = id;
    }
}
