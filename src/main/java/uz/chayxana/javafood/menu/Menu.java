package uz.chayxana.javafood.menu;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;

    public Menu() {
    }

    public Menu(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Menu setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setPrice(String price) {
        this.name = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Menu setDescription(String description) {
        this.description = description;
        return this;
    }
}
