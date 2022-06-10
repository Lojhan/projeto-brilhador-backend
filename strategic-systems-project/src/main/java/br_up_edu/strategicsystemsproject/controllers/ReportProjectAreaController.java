package br_up_edu.strategicsystemsproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br_up_edu.strategicsystemsproject.domain.Project;
import br_up_edu.strategicsystemsproject.domain.ReportProjectArea;
import br_up_edu.strategicsystemsproject.repository.AreaRepository;
import br_up_edu.strategicsystemsproject.repository.ProjectRepository;
import br_up_edu.strategicsystemsproject.repository.ReportProjectAreaRepository;

@RestController
public class ReportProjectAreaController {
    
    public final ReportProjectAreaRepository reportRepository;
    public final AreaRepository areaRepository;
    public final ProjectRepository projectRepository;

    ReportProjectAreaController(ReportProjectAreaRepository reportProjectAreaRepository, AreaRepository areaRepository, ProjectRepository projectRepository) {
        this.reportRepository = reportProjectAreaRepository;
        this.areaRepository = areaRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/project-area")
    Iterable<ReportProjectArea> list() {

        reportRepository.deleteAll();

        var area_repository = areaRepository.findAll();
        var project_repository = projectRepository.findAll();

        // relacionando projeto(s) a respectiva area
        for(Project project : project_repository) {
            ReportProjectArea ReportProjectArea = new ReportProjectArea();
            ReportProjectArea.setProject(project.getName());
            ReportProjectArea.setDescription(project.getDescription());
            area_repository.forEach(area->{
                if(area.getId() == project.getId_area()) {
                    ReportProjectArea.setArea(area.getName());
                }
            });
            reportRepository.save(ReportProjectArea);
        }
        
        return reportRepository.findAll();
    }


}
