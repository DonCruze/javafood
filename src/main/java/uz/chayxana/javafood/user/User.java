package uz.chayxana.javafood.user;

import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.UserRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Optional;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="surmane")
    private String surname;
    @Column(name ="login")
    private String login;
    @Column(name ="password")
    private String password;
    @Column(name="role")
    private ROLE role;

    @Column(name = "trash")
    private Boolean trash = false;


    public enum ROLE {
        ADMIN,MODERATOR,USER
    }

    public User() {
    }

    public User(Long id, String name, String surname, String login, String password, ROLE role, Boolean trash) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
        this.trash = trash;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public ROLE getRole() {
        return role;
    }

    public User setRole(ROLE role) {
        this.role = role;
        return this;
    }

    public static User reqToEntity(UserRequest req) {
        return reqToEntity(new User(), req);
    }

    public static User reqToEntity(User entity, UserRequest req) {
        Optional.ofNullable(req.getName()).ifPresent(entity::setName);
        Optional.ofNullable(req.getSurname()).ifPresent(entity::setSurname);
        Optional.ofNullable(req.getLogin()).ifPresent(entity::setLogin);
        Optional.ofNullable(req.getRole()).ifPresent(entity::setRole);
        return entity;
    }

    public User setTrash(Boolean trash) {
        this.trash = trash;
        return this;
    }
}
