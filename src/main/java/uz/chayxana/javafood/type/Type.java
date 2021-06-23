package uz.chayxana.javafood.type;

import lombok.Data;
import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    Set<Organization> organizations;
    @Column(name = "Name")
    private String name;

    public Type() {
    }
}
