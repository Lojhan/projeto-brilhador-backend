package br.edu.up.pessoa.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.pessoa.domain.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	public static Pessoa calculoFerias(Pessoa p) {
		double valorReceber = p.getSalario() / 3;
		p.setVlrFerias(valorReceber);
		return p;

	}

	public static Pessoa calculoSalario(Pessoa p, int horaExtra) {
		// efetuar calculo salario mensal
		double salarioBruto = p.getSalario();
		double vlrHoraExtra = 0;
				
		double salarioLiquido = p.getSalarioLiquido();
		double inss = 0;
		double irpf = 0;
		
		//calculo hora extra
		vlrHoraExtra = (salarioBruto / 200);
		salarioBruto = salarioBruto + vlrHoraExtra * horaExtra;

		// verificar aliquota do inss para salario
		if (salarioBruto >= 1100.00) {
			inss = 7.5 / 100;
		}
		if (salarioBruto >= 2203.48) {
			inss = 9.0 / 100;
		}
		if (salarioBruto >= 3305.22) {
			inss = 12.0 / 100;
		}
		if (salarioBruto >= 6433.57) {
			inss = 14.0 / 100;
		}
		if (salarioBruto < 1100) {
			inss = 0;
		}

		// verificar aliquota do inss para salario
		if (salarioBruto <= 1903.98) {
			irpf = 0;
		}
		if (salarioBruto > 1903.98) {
			irpf = 7.5  / 100;
		}
		if (salarioBruto >= 2826.66) {
			irpf = 15.0  / 100;
		}
		if (salarioBruto >= 3751.05) {
			irpf = 22.5  / 100;
		}
		if (salarioBruto >= 4664.68) {
			irpf = 27.5  / 100;
		}
		
		inss = salarioBruto * inss;
		salarioLiquido = salarioBruto - inss;
		
		irpf = salarioBruto * irpf;
		salarioLiquido = salarioLiquido - irpf;
		

		p.setSalarioLiquido(salarioLiquido);
		return p;

	}

}
