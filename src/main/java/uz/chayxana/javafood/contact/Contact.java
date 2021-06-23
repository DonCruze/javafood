package uz.chayxana.javafood.contact;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "number", unique = true)
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Long organizationId;

    public Contact() {
    }

    public Contact(Long id, String type, String info, Long organizationId) {
        this.id = id;
        this.type = type;
        this.info = info;
        this.organizationId = organizationId;
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

    public Long getOrganizationId() {
        return organizationId;
    }

    public Contact setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
        return this;
    }
}
