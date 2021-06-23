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
    private Long id;
    @Column (name = "name", unique = true)
            private String name;
    @Column (name = "name")
            private long price;
    @Column (name = "price")
            private String description;
    @Column (name = "description",length = 4000)
            private String organizationID;
    @Column (name = "organizationID")


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
