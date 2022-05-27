package br_up_edu.strategicsystemsproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Area {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;;
    private String objetive;

    public Area() {
       
    }

    public Area(String name, String objetive) {
        this.name = name;
        this.objetive = objetive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getObjective() {
        return objetive;
    }

    public void setObjective(String objetive) {
        this.objetive = objetive;
    }

}
