package uz.chayxana.javafood.organizationMenu;

import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "oraganizationMenu")
public class OrganizationMenu {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    private Set<Organization> organizations;

//    @OneToMany(mappedBy = "organizationMenu")
//    private ArrayList<Menu> menus;

    public OrganizationMenu() {
    }

    public OrganizationMenu(Long id, String name, Set<Organization> organizations) {
        this.id = id;
        this.name = name;
        this.organizations = organizations;
    }

    public Long getId() {
        return id;
    }

    public OrganizationMenu setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrganizationMenu setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public OrganizationMenu setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
        return this;
    }
}
