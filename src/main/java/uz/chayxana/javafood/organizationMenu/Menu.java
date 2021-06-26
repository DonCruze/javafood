package uz.chayxana.javafood.organizationMenu;

import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nulluble = false)
    private Organization organizations;

    @OneToMany(mappedBy = "Menu")
    private List<Menu> menus;

    public Menu() {
    }

    public Menu(Long id, String name, Set<Organization> organizations) {
        this.id = id;
        this.name = name;
        this.organizations = organizations;
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

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public Menu setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
        return this;
    }
}
