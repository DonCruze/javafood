package uz.chayxana.javafood.organizationMenu;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "oraganizationMenu")
public class OrganizationMenu {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Price")
    private Long price;
    @Column(name = "Time")
    private Time time;
    @Column(name = "Organization_id")
    private Long organization_id;
    @Column(name = "Menu_id")
    private Long menu_id;


    public OrganizationMenu() {
    }

    public OrganizationMenu(Long id, Long price, Time time, Long organization_id, Long menu_id) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.organization_id = organization_id;
        this.menu_id = menu_id;
    }

    public Long getId() {
        return id;
    }

    public OrganizationMenu setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public OrganizationMenu setPrice(Long price) {
        this.price = price;
        return this;
    }

    public Time getTime() {
        return time;
    }

    public OrganizationMenu setTime(Time time) {
        this.time = time;
        return this;
    }

    public Long getOrganization_id() {
        return organization_id;
    }

    public OrganizationMenu setOrganization_id(Long organization_id) {
        this.organization_id = organization_id;
        return this;
    }

    public Long getMenu_id() {
        return menu_id;
    }

    public OrganizationMenu setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
        return this;
    }
}
