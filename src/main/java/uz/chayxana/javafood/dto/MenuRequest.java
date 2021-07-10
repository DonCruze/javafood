package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuRequest {

    @JsonProperty("name")
    private String name;

    public MenuRequest() {
    }

    public MenuRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
