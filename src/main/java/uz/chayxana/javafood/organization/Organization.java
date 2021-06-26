package uz.chayxana.javafood.organization;

import lombok.Data;
import uz.chayxana.javafood.additionalService.Additional;
import uz.chayxana.javafood.contact.Contact;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.organizationMenu.Menu;
import uz.chayxana.javafood.type.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private Set<Type> types;

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "star_time")
    private Long star_time;
    @Column(name = "end_time")
    private Long end_time;
    @Column(name = "description")
    private String description;
    @Column(name = "location")
    private String location;
    @Column(name = "logo")
    private String logo;

    @OneToMany(mappedBy = "organization")
    private List<Delivery> deliveries = new ArrayList<>();

    @OneToMany(mappedBy = "organization")
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "organization")
    private List<Additional> addServices = new ArrayList<>();

    @OneToMany(mappedBy = "organization")
    private List<Menu> menus = new ArrayList<>();

}
