package uz.chayxana.javafood.contact;

import com.sun.istack.NotNull;
import uz.chayxana.javafood.dto.ContactRequest;
import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "type")
    @NotNull
    private String type;
    @NotNull
    @Column(name = "number")
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public static Contact dtoToEntity(ContactRequest req) {
        Contact contact = new Contact();
        Optional.ofNullable(req.getInfo()).ifPresent(contact::setInfo);
        Optional.ofNullable(req.getType()).ifPresent(contact::setType);
        return contact;
    }

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

    public Contact setOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }
}
