package br.edu.up.planocontas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PlanoContas {

  @Id
  @GeneratedValue
  private Long id;
  private String nome;
  private String natureza;
  private String classificacao;

  public PlanoContas(String nome, String natureza, String classificacao) {
    this.nome = nome;
    this.natureza = natureza;
    this.classificacao = classificacao;
  }

  public PlanoContas(String nome) {
    this.nome = nome;
  }

  public PlanoContas() {
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

  public String getNatureza() {
    return natureza;
  }

  public void setNatureza(String natureza) {
    this.natureza = natureza;
  }

  public String getClassificacao() {
    return classificacao;
  }

  public void setClassificacao(String classificacao) {
    this.classificacao = classificacao;
  }

}
