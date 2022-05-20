package edu.up.br.projeto_dev_software.domain.domain_folha_pgto;

public class FolhaPgto {
    
    private String nomeFuncionario;
    private String cpfFuncioanrio;
    private Double salário;
    private Double descontoPlanoSaude;
    private Double descontoTrans;
    private Double valorPagar;

    public Double getValorPagar() {
        return valorPagar;
    }
    public void setValorPagar(Double valorPagar) {
        this.valorPagar = valorPagar;
    }
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    public String getCpfFuncioanrio() {
        return cpfFuncioanrio;
    }
    public void setCpfFuncioanrio(String cpfFuncioanrio) {
        this.cpfFuncioanrio = cpfFuncioanrio;
    }
    public Double getSalário() {
        return salário;
    }
    public void setSalário(Double salário) {
        this.salário = salário;
    }
    public Double getDescontoPlanoSaude() {
        return descontoPlanoSaude;
    }
    public void setDescontoPlanoSaude(Double descontoPlanoSaude) {
        this.descontoPlanoSaude = descontoPlanoSaude;
    }
    public Double getDescontoTrans() {
        return descontoTrans;
    }
    public void setDescontoTrans(Double descontoTrans) {
        this.descontoTrans = descontoTrans;
    }



}
