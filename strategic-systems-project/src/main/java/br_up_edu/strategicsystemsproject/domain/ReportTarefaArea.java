package br_up_edu.strategicsystemsproject.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReportTarefaArea {
    
    @Id
    @GeneratedValue
    private String name = "Relatório de tarefa por área";
    private Long id_area;
    private Long id_tarefa;


    public ReportTarefaArea() {

    }

}
