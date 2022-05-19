package edu.up.br.projeto_dev_software.domain.domain_plano_saude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PlanoSaude{

    @Id
    @GeneratedValue
    private Long id;
    private String nomePlano;
    private double ValorIndividual;
    private double ValorFamiliar;

    public PlanoSaude() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnomePlano() {
        return nomePlano;
    }

    public void setnomePlano(String nome) {
        this.nomePlano = nome;
    }

    public double getValorIndividual() {
        return ValorIndividual;
    }

    public void setValorIndividual(double valorIndividual) {
        ValorIndividual = valorIndividual;
    }

    public double getValorFamiliar() {
        return ValorFamiliar;
    }

    public void setValorFamiliar(double valorFamiliar) {
        ValorFamiliar = valorFamiliar;
    }
    
}
