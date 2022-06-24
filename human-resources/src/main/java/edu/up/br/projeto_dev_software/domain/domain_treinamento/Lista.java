package edu.up.br.projeto_dev_software.domain.domain_treinamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import edu.up.br.projeto_dev_software.domain.domain_cadastro_funcionario.Funcionario;

@Entity
@Table(name = "tb_treinamento")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeTreinamento;
    private String area;

    @ManyToMany
    @JoinTable(name = "pessoas_treinamento",
                joinColumns = {@JoinColumn(name="id_treinamento")},
                inverseJoinColumns = {@JoinColumn(name="id_funcionario")})
    private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();


    public List<Funcionario> getFuncionarios() {
        return listaFuncionarios;
    }

    public void setFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
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
