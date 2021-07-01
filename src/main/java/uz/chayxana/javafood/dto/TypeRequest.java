package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.io.Serializable;

public class TypeRequest implements Serializable {

    @JsonProperty("name")
    private String name;

    public TypeRequest() {
    }

    public TypeRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
