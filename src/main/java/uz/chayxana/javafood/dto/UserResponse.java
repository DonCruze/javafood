package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.user.User;

import java.util.Optional;

public class UserResponse {


    @JsonProperty("name")
    private String name;

    @JsonProperty("surmane")
    private String surname;
    @JsonProperty("login")
    private String login;
    @JsonProperty("role")
    User.ROLE role;

    public UserResponse() {
    }

    public UserResponse(String name, String surname, String login, User.ROLE role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.role = role;
    }


    public static UserResponse entityToResponse(User entity) {
        UserResponse response = new UserResponse();
        Optional.ofNullable(entity.getName()).ifPresent(response::setName);
        Optional.ofNullable(entity.getSurname()).ifPresent(response::setSurname);
        Optional.ofNullable(entity.getLogin()).ifPresent(response::setLogin);
        Optional.ofNullable(entity.getRole()).ifPresent(response::setRole);
        return response;
    }

    public String getName() {
        return name;
    }

    public UserResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserResponse setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserResponse setLogin(String login) {
        this.login = login;
        return this;
    }

    public User.ROLE getRole() {
        return role;
    }

    public UserResponse setRole(User.ROLE role) {
        this.role = role;
        return this;
    }
}
