package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import uz.chayxana.javafood.menu.Menu;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuResponse {

    @JsonProperty("name")
    private String name;

    public static MenuResponse entityToResponse(Menu entity) {
        MenuResponse response = new MenuResponse();
        Optional.ofNullable(entity.getName()).ifPresent(response::setName);
        return response;
    }

    public MenuResponse() {
    }

    public MenuResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MenuResponse setName(String name) {
        this.name = name;
        return this;
    }
}
