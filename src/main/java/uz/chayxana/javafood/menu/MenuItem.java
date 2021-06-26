package uz.chayxana.javafood.menu;

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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "menu_id", nullable = false)
//    private Menu menus;

    public MenuItem() {
    }

    public MenuItem(Long id, Long price, Time time, String name, String description, Menu menus) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.name = name;
        this.description = description;
//        this.menus = menus;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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

//    public void setMenus(Menu menu) {
//        this.menus = menu;
//    }
}
