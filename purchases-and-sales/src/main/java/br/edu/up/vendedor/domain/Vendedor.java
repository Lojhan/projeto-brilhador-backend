package br.edu.up.vendedor.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double comissao;

    

    public Vendedor() {
    }

    public Vendedor(String nome) {
        this.nome = nome;
    }

    public Vendedor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Vendedor(String nome, double comissao) {
        this.nome = nome;
        this.comissao = comissao;
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

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    @Override
    public String toString() {
      return String.format(
          "Customer[id=%s, nome='%s', comissao='%s']",
          id, nome, comissao);
    }
}
