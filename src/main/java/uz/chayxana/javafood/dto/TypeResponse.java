package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.type.Type;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeResponse implements Serializable {

    @JsonProperty("name")
    private String name;


    public TypeResponse() {
    }

    public static TypeResponse entityToResponse(Type entity) {
        TypeResponse response = new TypeResponse();
        Optional.ofNullable(entity.getName()).ifPresent(s -> response.setName(s));
        return response;
    }


    public TypeResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
