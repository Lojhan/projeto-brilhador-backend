package br_up_edu.strategicsystemsproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReportProjectArea {
    
    @Id
    @GeneratedValue
    private Long id;
    private String project;
    private String description;
    private String area;


    public ReportProjectArea() {
        
    }

    public ReportProjectArea(String project, String description, String area) {
        this.project = project;
        this.description = description;
        this.area = area;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
