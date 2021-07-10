package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import uz.chayxana.javafood.additionalService.Additional;
import uz.chayxana.javafood.contact.Contact;

import java.util.Optional;

public class AdditionalResponse {
    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private long price;

    @JsonProperty("description")
    private String description;

    public static AdditionalResponse entityToResponse(Additional entity) {
        AdditionalResponse response = new AdditionalResponse();
        Optional.ofNullable(entity.getName()).ifPresent(response::setName);
        Optional.ofNullable(entity.getPrice()).ifPresent(response::setPrice);
        Optional.ofNullable(entity.getDescription()).ifPresent(response::setDescription);
        return response;
    }

    public AdditionalResponse() {
    }

    public AdditionalResponse(String name, long price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public AdditionalResponse setName(String name) {
        this.name = name;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public AdditionalResponse setPrice(long price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AdditionalResponse setDescription(String description) {
        this.description = description;
        return this;
    }
}

