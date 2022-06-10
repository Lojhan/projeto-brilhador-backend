package br.edu.up.financial.lancamentos_contabeis.Domain;

import java.util.ArrayList;
import java.util.List;

public class MovementList {
    private List<Movement> movements;

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public MovementList(){
        movements = new ArrayList<>();
    }
    
}
