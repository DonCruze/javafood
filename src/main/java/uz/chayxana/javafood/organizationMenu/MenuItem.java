package uz.chayxana.javafood.organizationMenu;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "menu_item")
public class MenuItem {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    public MenuItem() {
    }

    public MenuItem(Long id, Long price, Time time, String name, String description) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public MenuItem setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public MenuItem setPrice(Long price) {
        this.price = price;
        return this;
    }

    public Time getTime() {
        return time;
    }

    public MenuItem setTime(Time time) {
        this.time = time;
        return this;
    }

    public String getName() {
        return name;
    }

    public MenuItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem setDescription(String description) {
        this.description = description;
        return this;
    }
}
