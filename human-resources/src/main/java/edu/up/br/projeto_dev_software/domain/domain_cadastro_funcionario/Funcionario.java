package edu.up.br.projeto_dev_software.domain.domain_cadastro_funcionario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.up.br.projeto_dev_software.domain.domain_plano_saude.PlanoSaude;
import edu.up.br.projeto_dev_software.domain.domain_treinamento.Lista;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

    // Atributos de funcionários
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String dataNasc;
    private String cpf;
    private String dataContr;
    private Double salario;
    private String status;

    private String descricao;
    private boolean trans;


    @ManyToOne
    @JoinColumn(name = "id_plano_Saude")
    private PlanoSaude planoSaude;

    @ManyToOne
    @JoinColumn(name = "id_lista_Treinamento")
    private Lista listaTreinamento; 

    //Construtor =====================================
    public Funcionario(){
        
    }

    // Setter
    public void setPlanoSaude(PlanoSaude planoSaude) {
        this.planoSaude = planoSaude;
    }

    public void setListaTreinamento(Lista listaTreinamento) {
        this.listaTreinamento = listaTreinamento;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataContr(String dataContr) {
        this.dataContr = dataContr;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    
    public void setTrans(boolean trans) {
        this.trans = trans;
    }

    // Getter
    // ============================================================================
    public PlanoSaude getPlanoSaude() {
        return planoSaude;
    }

    public Lista getListaTreinamento() {
        return listaTreinamento;
    }

    public long getId() {
        return id;
    };

    public String getNome() {
        return nome;
    };

    public String getEmail() {
        return email;
    };

    public String getDataNasc() {
        return dataNasc;
    };

    public String getCpf() {
        return cpf;
    };

    public String getDataContr() {
        return dataContr;
    };

    public Double getSalario() {
        return salario;
    };

    public boolean getTrans() {
        return trans;
    };

    public String getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

}
