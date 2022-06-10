package br_up_edu.strategicsystemsproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReportTaskProject {
    
    @Id
    @GeneratedValue
    private Long id;
    private String task;
    private String description;
    private String project;

    public ReportTaskProject(){

    }

    public ReportTaskProject(String task, String description, String project) {
        this.task = task;
        this.description = description;
        this.project = project;
    }
    
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}
