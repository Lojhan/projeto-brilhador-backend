package edu.up.br.projeto_dev_software.domain.domain_treinamento;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lista {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

public Lista(){

}

public Lista(String nome) {
    this.nome = nome;
}

public Lista(Long id, String nome){

this.id = id;
this.nome = nome;

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

}


