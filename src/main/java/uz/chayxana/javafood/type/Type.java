package uz.chayxana.javafood.type;

import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    Set<Organization> organization;

    @Column(name = "Name")
    private String name;

    public Type() {
    }

    public Type(Long id, Set<Organization> organization, String name) {
        this.id = id;
        this.organization = organization;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Type setId(Long id) {
        this.id = id;
        return this;
    }

    public Set<Organization> getOrganization() {
        return organization;
    }

    public Type setOrganization(Set<Organization> organization) {
        this.organization = organization;
        return this;
    }

    public String getName() {
        return name;
    }

    public Type setName(String name) {
        this.name = name;
        return this;
    }
}
