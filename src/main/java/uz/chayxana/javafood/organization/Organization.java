package uz.chayxana.javafood.organization;

import lombok.Data;
import uz.chayxana.javafood.additionalService.Additional;
import uz.chayxana.javafood.contact.Contact;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.dto.OrganizationRequest;
import uz.chayxana.javafood.menu.Menu;
import uz.chayxana.javafood.type.Type;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "organization_types",
            joinColumns = { @JoinColumn(name = "organization_id") },
            inverseJoinColumns = { @JoinColumn(name = "type_id") })
    private Set<Type> types = new HashSet<>();

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "star_time")
    private Long starTime;
    @Column(name = "end_time")
    private Long endTime;
    @Column(name = "description")
    private String description;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "logo")
    private String logo;

    @OneToOne(cascade = CascadeType.ALL)
    private Delivery delivery;

    @OneToMany(mappedBy = "organization")
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "organization")
    private List<Additional> addServices = new ArrayList<>();

    @OneToMany(mappedBy = "organization")
    private List<Menu> menus = new ArrayList<>();

    @Column(name = "trash")
    private Boolean trash = false;

    public static Organization reqToEntity(OrganizationRequest req) {
        return reqToEntity(new Organization(), req);
    }

    public static Organization reqToEntity(Organization entity, OrganizationRequest req) {
        Optional.ofNullable(req.getName()).ifPresent(s -> entity.setName(s));
        Optional.ofNullable(req.getDescription()).ifPresent(entity::setDescription);
        Optional.ofNullable(req.getLogo()).ifPresent(entity::setLogo);
//        StringBuilder location = new StringBuilder();
//        location.append("lat:");
//        Optional.ofNullable(req.getLatitude()).ifPresent(s -> location.append(s));
//        location.append(",lon:");
//        Optional.ofNullable(req.getLongitude()).ifPresent(location::append);
//        entity.setLocation(location.toString());
        Optional.ofNullable(req.getLatitude()).ifPresent(entity::setLatitude);
        Optional.ofNullable(req.getLongitude()).ifPresent(entity::setLongitude);
        Optional.ofNullable(req.getStarTime()).ifPresent(entity::setStarTime);
        Optional.ofNullable(req.getEndTime()).ifPresent(entity::setEndTime);
        Optional.ofNullable(req.getDelivery()).ifPresent(delivery -> {
//            entity.getDelivery().setExtraPrice();
            Delivery temp = new Delivery();
            temp.setPrice(delivery.getPrice());
            temp.setExtraPrice(delivery.getExtraPrice());
            temp.setStartTime(delivery.getStarTime());
            temp.setEndTime(delivery.getEndTime());
            entity.setDelivery(temp);
        });
        return entity;
    }
}
