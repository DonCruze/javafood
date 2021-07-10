package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;



public class AdditionalRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private long price;

    @JsonProperty("description")
    private String description;

    public AdditionalRequest() {
    }

    public AdditionalRequest(String name, long price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
