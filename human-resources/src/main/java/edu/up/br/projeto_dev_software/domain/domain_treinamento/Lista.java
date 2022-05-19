package edu.up.br.projeto_dev_software.domain.domain_treinamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lista {

    @Id
    @GeneratedValue
    private Long id;
    private String nomeTreinamento;
    private String area;

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
