package edu.up.br.projeto_dev_software.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import edu.up.br.projeto_dev_software.domain.domain_cadastro_funcionario.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>  {
    List<Funcionario>findByCpf(String cpf);

}
