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

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private Long price;

    @Column(name = "description", length = 4000)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public Additional() {
    }

    public Additional(Long id, String name, Long price, String description, Organization organization) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public Additional setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Additional setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public Additional setPrice(Long price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Additional setDescription(String description) {
        this.description = description;
        return this;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Additional setOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }

}
