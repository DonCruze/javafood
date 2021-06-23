package uz.chayxana.javafood.contact;

import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "number")
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public Contact() {
    }

    public Contact(Long id, String type, String info, Organization organization) {
        this.id = id;
        this.type = type;
        this.info = info;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public Contact setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Contact setType(String type) {
        this.type = type;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public Contact setInfo(String info) {
        this.info = info;
        return this;
    }

    public Contact setOrganizationId(Organization organization) {
        this.organization = organization;
        return this;
    }
}
