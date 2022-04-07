package br_up_edu.strategicsystemsproject.repository;

import org.springframework.data.repository.CrudRepository;
import br_up_edu.strategicsystemsproject.domain.Project;
import java.util.List;
import java.util.ArrayList;

public interface ProjectRepository extends CrudRepository<Project, Long>{


}