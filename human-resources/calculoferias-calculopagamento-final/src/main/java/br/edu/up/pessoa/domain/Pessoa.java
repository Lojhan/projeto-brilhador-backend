package br.edu.up.pessoa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String dtNasc;
    private String cpf;
    private String dtContratacao;
	private double salario;
	private double salarioLiquido;
	private double vlrFerias;
	private String banco;
    private String agencia;
    private String conta;
    

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String dtNasc, String cpf, String dtContratacao, double salario, double salarioLiquido, double vlrFerias, String banco, String agencia, String conta) {
        this.nome = nome;
        this.email = email;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
		this.dtContratacao = dtContratacao;
		this.salario = salario;
		this.salarioLiquido = salarioLiquido;
		this.vlrFerias = vlrFerias;
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
    }

    public Pessoa(Long id, String nome, String email, String dtNasc, String cpf, String dtContratacao, double salario, double salarioLiquido, double vlrFerias, String banco, String agencia, String conta) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
		this.dtContratacao = dtContratacao;
		this.salario = salario;
		this.salarioLiquido = salarioLiquido;
		this.vlrFerias = vlrFerias;
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtContratacao() {
		return dtContratacao;
	}

	public void setDtContratacao(String dtContratacao) {
		this.dtContratacao = dtContratacao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public double getVlrFerias() {
		return vlrFerias;
	}

	public void setVlrFerias(double vlrFerias) {
		this.vlrFerias = vlrFerias;
	}
	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

    
    
}
