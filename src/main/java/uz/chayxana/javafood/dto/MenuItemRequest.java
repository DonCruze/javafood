package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class MenuItemRequest {

    @JsonProperty("Price")
    private Long price;
    @JsonProperty("Time")
    private Timestamp time;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;

    public MenuItemRequest() {
    }

    public MenuItemRequest(Long price, Timestamp time, String name, String description) {
        this.price = price;
        this.time = time;
        this.name = name;
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
