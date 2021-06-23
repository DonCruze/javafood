package uz.chayxana.javafood.organization;

import lombok.Data;
import uz.chayxana.javafood.additionalService.Additional;
import uz.chayxana.javafood.contact.Contact;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue
    private Long id;
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
    @Column(name = "delivery")
    private Boolean delivery;

    @OneToMany(mappedBy = "organization")
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "organization")
    private List<Additional> addServices = new ArrayList<>();
}
