package br_up_edu.strategicsystemsproject.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br_up_edu.strategicsystemsproject.domain.ReportTarefaArea;
import br_up_edu.strategicsystemsproject.repository.ReportTarefaAreaRepository;
import br_up_edu.strategicsystemsproject.repository.TaskRepository;
import br_up_edu.strategicsystemsproject.repository.AreaRepository;

@RestController
public class ReportTarefaAreaController {

    private final ReportTarefaAreaRepository reportTarefaAreaRepository;
    private final AreaRepository areaRepository;
    private final TaskRepository taskRepository;

    ReportTarefaAreaController(
        ReportTarefaAreaRepository reportTarefaAreaRepository, AreaRepository areaRepository, TaskRepository taskRepository )
    {
        this.reportTarefaAreaRepository = reportTarefaAreaRepository;
        this.areaRepository = areaRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tarefa-area")
    Iterable<ReportTarefaArea> list() {
        reportTarefaAreaRepository = areaRepository.getName();
        return reportTarefaAreaRepository;
    }
    
    @GetMapping("/tarefa-area/{id}")
    ReportTarefaArea findTaskById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/area-tarefa")
    ReportTarefaArea include(@RequestBody ReportTarefaArea newReportTarefaArea){
        return repository.save(newReportTarefaArea);
    }

    @PutMapping("/tasks/{id}")
    ReportTarefaArea update(@RequestBody ReportTarefaArea taskUpdated, @PathVariable Long id){
        return repository.findById(id)
        .map(Task -> {
            Task.setName(taskUpdated.getName());
            return repository.save(Task);
        })
        .orElseGet(() -> {
            taskUpdated.setId(id);
            return repository.save(taskUpdated);
        });    
    }

}
