package br.edu.up.inventory.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private int quantityProduced;

    @Column(name = "id_product")
    private long idProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_product", updatable = false, insertable = false)
    private Product product;

    @OneToMany(mappedBy="process", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients;

    public Process() {

    }

    public Process(long id, String name, String description, int quantityProduced, long idProduct) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantityProduced = quantityProduced;
        this.idProduct = idProduct;
    }

    public void updateProcess(Process updatedProcess) {
        this.name = updatedProcess.getName();
        this.description = updatedProcess.getDescription();
        this.quantityProduced = updatedProcess.getQuantityProduced();
        this.idProduct = updatedProcess.getIdProduct();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityProduced() {
        return quantityProduced;
    }

    public void setQuantityProduced(int quantityProduced) {
        this.quantityProduced = quantityProduced;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }
}
