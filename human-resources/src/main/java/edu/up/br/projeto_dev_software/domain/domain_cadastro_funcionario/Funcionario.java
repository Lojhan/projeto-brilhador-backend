package edu.up.br.projeto_dev_software.domain.domain_cadastro_funcionario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario {

    // Atributos de funcionários
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String dataNasc;
    private String cpf;
    private String dataContr;
    private double salario;
    private double ferias;
    private String status;
    private String descricao;
    private boolean Trans;
    private double descTrans;
    private boolean planoSaude;
    private int tipoSaude;
    private double descSaude;

    // Setter
    public void setId(Long id){
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setdataNasc(String dataNasc) {
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
        this.ferias = salario + (salario * 0.33);
    }

    public void setTrans(boolean Trans) {
        this.Trans = Trans;
    }

    public void setPlanoSaude(boolean planoSaude) {
        this.planoSaude = planoSaude;
    }

    public void setTipoSaude(int tipoSaude) {
        this.tipoSaude = tipoSaude;
        descSaude();
        descTrans();
    }

    //funções====================================================================

        //Desconto vale transporte
        public void descTrans() {

            if (Trans == true) {
                this.descTrans = salario * 0.06;
            } else {
                this.descTrans = 0;
            }
        }

        //Descontro plano de saude
        public void descSaude() {
            if (planoSaude == true) {
                switch (tipoSaude) {

                    case 1:
                        this.descSaude = 100.02;
                        break;

                    case 2:
                        this.descSaude = 150;
                        break;
                }
            } else {
                this.descSaude = 0;
            }
        }

    // Getter
    // ============================================================================

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

    public Double getFerias() {
        return ferias;
    };

    public boolean getTrans() {
        return Trans;
    };
    
    public Double getDescTrans() {
        return descTrans;
    };

    public boolean getPlanoSaude() {
        return planoSaude;
    };

    public int getTipoSaude() {
        return tipoSaude;
    };

    public Double getDescSaude() {
        return descSaude;
    };

    public String getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

}
