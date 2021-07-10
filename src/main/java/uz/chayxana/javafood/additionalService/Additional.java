package uz.chayxana.javafood.additionalService;

import uz.chayxana.javafood.contact.Contact;
import uz.chayxana.javafood.dto.AdditionalRequest;
import uz.chayxana.javafood.dto.ContactRequest;
import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "additional_service")
public class Additional {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "price")
    private long price;

    @Column(name = "description", length = 4000)
    private String description;

    @Column(name = "trash")
    private Boolean trash = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;


    public Additional() {
    }

    public Additional(Long id, String name, long price, String description, Organization organization) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.organization = organization;
    }

    public static Additional dtoToEntity(AdditionalRequest req) {
        return dtoToEntity(new Additional(), req);
    }
    public static Additional dtoToEntity(Additional additional, AdditionalRequest req) {
        Optional.ofNullable(req.getName()).ifPresent(additional::setName);
        Optional.ofNullable(req.getPrice()).ifPresent(additional::setPrice);
        Optional.ofNullable(req.getDescription()).ifPresent(additional::setDescription);
        return additional;
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

    public long getPrice() {
        return price;
    }

    public Additional setPrice(long price) {
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

    public Boolean getTrash() {
        return trash;
    }

    public Additional setTrash(Boolean trash) {
        this.trash = trash;
        return this;
    }


    public Additional setOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }
}
