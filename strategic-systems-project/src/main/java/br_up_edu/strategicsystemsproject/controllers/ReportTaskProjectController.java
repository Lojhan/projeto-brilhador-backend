package br_up_edu.strategicsystemsproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br_up_edu.strategicsystemsproject.domain.ReportTaskProject;
import br_up_edu.strategicsystemsproject.domain.Task;
import br_up_edu.strategicsystemsproject.repository.ProjectRepository;
import br_up_edu.strategicsystemsproject.repository.ReportTaskProjectRepository;
import br_up_edu.strategicsystemsproject.repository.TaskRepository;

@RestController
public class ReportTaskProjectController {

    public final ReportTaskProjectRepository repository;
    public final TaskRepository taskRepository;
    public final ProjectRepository projectRepository;

    ReportTaskProjectController(ReportTaskProjectRepository repository, TaskRepository taskRepository, ProjectRepository projectRepository){
        this.repository = repository;
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/tarefa-area")
    Iterable<ReportTaskProject> list() {
         
        repository.deleteAll();

        var task_repository = taskRepository.findAll();
        var project_repository = projectRepository.findAll();

        // relacionando tarefa à respectiva área
        for(Task task : task_repository) {
            ReportTaskProject ReportTaskProject = new ReportTaskProject();
            ReportTaskProject.setTask(task.getName());
            ReportTaskProject.setDescription(task.getDescription());
            project_repository.forEach(project->{
                if(project.getId() == task.getId_area()) {
                    ReportTaskProject.setProject(project.getName());
                }
            });
            repository.save(ReportTaskProject);
        }

        return repository.findAll();

    }
}
