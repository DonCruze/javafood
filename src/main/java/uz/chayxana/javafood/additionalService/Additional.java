package uz.chayxana.javafood.additionalService;

import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;

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

    public Additional setOrganization(Organization organization) {
        this.organization = organization;
        return this;
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
}
