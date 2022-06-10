package br_up_edu.strategicsystemsproject.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br_up_edu.strategicsystemsproject.domain.ReportTarefaArea;
import br_up_edu.strategicsystemsproject.domain.Task;
import br_up_edu.strategicsystemsproject.repository.AreaRepository;
import br_up_edu.strategicsystemsproject.repository.ReportTarefaAreaRepository;
import br_up_edu.strategicsystemsproject.repository.TaskRepository;

@RestController
public class ReportTarefaAreaController {

    public final ReportTarefaAreaRepository reportRepository;
    public final TaskRepository taskRepository;
    public final AreaRepository areaRepository;

    ReportTarefaAreaController(ReportTarefaAreaRepository repository, TaskRepository taskRepository, AreaRepository areaRepository){
        this.reportRepository = repository;
        this.taskRepository = taskRepository;
        this.areaRepository = areaRepository;
    }

     @GetMapping("/tarefa-area")
     Iterable<ReportTarefaArea> list() {
         
        reportRepository.deleteAll();

        var area_repository = areaRepository.findAll();
        var task_repository = taskRepository.findAll();

        // relacionando tarefa à respectiva área
        for(Task task : task_repository) {
            ReportTarefaArea ReportTarefaArea = new ReportTarefaArea();
            ReportTarefaArea.setTask(task.getName());
            ReportTarefaArea.setDescription(task.getDescription());
            area_repository.forEach(area->{
                if(area.getId() == task.getId_area()) {
                    ReportTarefaArea.setArea(area.getName());
                }
            });
            reportRepository.save(ReportTarefaArea);
        }

        return reportRepository.findAll();

    }

}
