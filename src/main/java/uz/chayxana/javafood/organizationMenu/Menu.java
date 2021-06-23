package uz.chayxana.javafood.organizationMenu;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Price")
    private Long price;
    @Column(name = "Time")
    private Time time;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "organizationMenu_id", nullable = false)
//    private OrganizationMenu organizationMenu;

    public Menu() {
    }

    public Menu(Long id, Long price, Time time, String name, String description) {
        this.id = id;
        this.price = price;
        this.time = time;
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

    public Long getPrice() {
        return price;
    }

    public Menu setPrice(Long price) {
        this.price = price;
        return this;
    }

    public Time getTime() {
        return time;
    }

    public Menu setTime(Time time) {
        this.time = time;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
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
