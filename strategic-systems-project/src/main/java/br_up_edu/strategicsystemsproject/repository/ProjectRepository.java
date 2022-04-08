package br_up_edu.strategicsystemsproject.repository;

import org.springframework.data.repository.CrudRepository;
import br_up_edu.strategicsystemsproject.domain.Project;
public interface ProjectRepository extends CrudRepository<Project, Long>{

    
}