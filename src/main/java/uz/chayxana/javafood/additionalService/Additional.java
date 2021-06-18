package uz.chayxana.javafood.additionalService;

import lombok.Data;
import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;

@Data
@Entity
@Table(name = "additional_service")
public class Additional {
    @Id
    @GeneratedValue
    Long id;

    String name;

    @Column(name = "description", length = 4000)
    String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
