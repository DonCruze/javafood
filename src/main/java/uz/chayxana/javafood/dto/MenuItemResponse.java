package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import uz.chayxana.javafood.menu.Menu;
import uz.chayxana.javafood.menu.MenuItem;

import java.sql.Timestamp;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuItemResponse {

    @JsonProperty("Price")
    private Long price;
    @JsonProperty("Time")
    private Timestamp time;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;

    public static MenuItemResponse entityToResponse(MenuItem entity) {
        MenuItemResponse response = new MenuItemResponse();
        Optional.ofNullable(entity.getPrice()).ifPresent(response::setPrice);
        Optional.ofNullable(entity.getTime()).ifPresent(response::setTime);
        Optional.ofNullable(entity.getName()).ifPresent(response::setName);
        Optional.ofNullable(entity.getDescription()).ifPresent(response::setDescription);
        return response;
    }

    public MenuItemResponse() {
    }

    public MenuItemResponse(Long price, Timestamp time, String name, String description) {
        this.price = price;
        this.time = time;
        this.name = name;
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public MenuItemResponse setPrice(Long price) {
        this.price = price;
        return this;
    }

    public Timestamp getTime() {
        return time;
    }

    public MenuItemResponse setTime(Timestamp time) {
        this.time = time;
        return this;
    }

    public String getName() {
        return name;
    }

    public MenuItemResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuItemResponse setDescription(String description) {
        this.description = description;
        return this;
    }
}
