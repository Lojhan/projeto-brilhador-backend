package edu.up.br.projeto_dev_software.domain.domain_treinamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_treinamento")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeTreinamento;
    private String area;

    public Lista(){
    }

    // Getter e setter ID =======================================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e setter Nome do treinamento
    public String getNomeTreinamento() {
        return nomeTreinamento;
    }

    public void setNomeTreinamento(String nomeTreinamento) {
        this.nomeTreinamento = nomeTreinamento;
    }

    // Getter e setter Area do funcionario que será realizado treinamento
    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

}
