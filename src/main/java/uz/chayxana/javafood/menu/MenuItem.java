package uz.chayxana.javafood.menu;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "menu_item")
public class MenuItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "price")
    private Long price;

    @Column(name = "Time")
    private Timestamp time;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "trash")
    private Boolean trash = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    public MenuItem() {
    }

    public MenuItem(Long id, Long price, Timestamp time, String name, String description, Menu menu) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.name = name;
        this.description = description;
        this.menu = menu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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

    public void setMenu(Menu menu) { this.menu = menu; }

    public Boolean getTrash() {
        return trash;
    }

    public MenuItem setTrash(Boolean trash) {
        this.trash = trash;
        return this;
    }
}
