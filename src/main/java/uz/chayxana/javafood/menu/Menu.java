package uz.chayxana.javafood.menu;

import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @OneToMany(mappedBy = "menu")
    private List<MenuItem> menuItems;

    public Menu() {
    }

    public Menu(Long id, String name, Organization organization, List<MenuItem> menuItems) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.menuItems = menuItems;
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

    public void setOrganization(Organization organizations) {
        this.organization = organizations;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
