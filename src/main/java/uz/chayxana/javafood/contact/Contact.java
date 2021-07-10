package uz.chayxana.javafood.contact;

import com.sun.istack.NotNull;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.dto.ContactRequest;
import uz.chayxana.javafood.dto.DeliveryRequest;
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
    private String number;

    @Column(name = "trash")
    private Boolean trash = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public static Contact dtoToEntity( ContactRequest req) {
        return dtoToEntity(new Contact(), req);
    }
    public static Contact dtoToEntity(Contact contact, ContactRequest req) {
        Optional.ofNullable(req.getNumber()).ifPresent(contact::setNumber);
        Optional.ofNullable(req.getType()).ifPresent(contact::setType);
        return contact;
    }

    public Contact() {
    }

    public Contact(Long id, String type, String number, Organization organization) {
        this.id = id;
        this.type = type;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public Contact setNumber(String number) {
        this.number = number;
        return this;
    }

    public Contact setOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public Contact setTrash(Boolean trash) {
        this.trash = trash;
        return this;
    }


}
