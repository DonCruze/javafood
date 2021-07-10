package uz.chayxana.javafood.dto;

import com.sun.istack.NotNull;

public class ContactRequest {
    @NotNull
    private String type;
    @NotNull
    private String number;

    public ContactRequest() {
    }

    public ContactRequest(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public static ContactRequest entityToDto() {
        return new ContactRequest();
    }

    public String getType() {
        return type;
    }

    public ContactRequest setType(String type) {
        this.type = type;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public ContactRequest setNumber(String number) {
        this.number = number;
        return this;
    }
}
