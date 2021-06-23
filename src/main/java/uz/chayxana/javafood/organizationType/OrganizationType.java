package uz.chayxana.javafood.organizationType;

import lombok.Data;
import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class OrganizationType {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "OrganizationType",
            joinColumns = @JoinColumn(name = "Type_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id"))
            Set<Organization> organizations;
    @Column(name = "Name")
    private String name;

    public OrganizationType() {
    }

}
