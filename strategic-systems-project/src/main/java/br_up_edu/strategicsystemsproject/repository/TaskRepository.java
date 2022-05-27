package br_up_edu.strategicsystemsproject.repository;

import org.springframework.data.repository.CrudRepository;
import br_up_edu.strategicsystemsproject.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{


    
}