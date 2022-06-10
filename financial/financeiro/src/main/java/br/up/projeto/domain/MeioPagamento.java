package br.up.projeto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MeioPagamento {

    @Id
    @GeneratedValue
    private Long id;
    private String meioPagamento;
    private String codigo;

    public MeioPagamento() {

    }
    public MeioPagamento(String meioPagamento, String codigo) {
        this.meioPagamento = meioPagamento;
        this.codigo = codigo;
    }

    public MeioPagamento(Long id, String meioPagamento, String codigo) {
        this.id = id;
        this.meioPagamento = meioPagamento;
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*--------------*/

    public String getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(String pagamento) {
        this.meioPagamento = pagamento;
    }

    /*--------------*/

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /*--------------*/

}
