package br_up_edu.strategicsystemsproject.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReportTarefaArea {
    
    @Id
    @GeneratedValue
    private Long id;
    private String area;
    private String task;
    private String description;


    public ReportTarefaArea() {
        
    }

    public ReportTarefaArea(String area, String task, String description) {
        this.setArea(area);
        this.setTask(task);
        this.setDescription(description);
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
