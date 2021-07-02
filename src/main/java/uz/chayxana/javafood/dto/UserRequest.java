package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import uz.chayxana.javafood.user.User;

import javax.persistence.Column;

public class UserRequest {


    @JsonProperty("name")
    private String name;

    @JsonProperty("surmane")
    private String surname;
    @JsonProperty("login")
    private String login;
    @JsonProperty("role")
    User.ROLE role;

    public UserRequest() {
    }

    public UserRequest(String name, String surname, String login, User.ROLE role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String Surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public User.ROLE getRole() {
        return role;
    }

    public void setRole(User.ROLE role) {
        this.role = role;
    }
}
