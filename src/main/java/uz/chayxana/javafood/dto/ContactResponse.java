package uz.chayxana.javafood.dto;

import uz.chayxana.javafood.contact.Contact;

import java.util.Optional;

public class ContactResponse {
    private Long id;
    private String type;
    private String info;

    public static ContactResponse entityToResponse(Contact contact) {
        ContactResponse response = new ContactResponse();
        Optional.ofNullable(contact.getId()).ifPresent(response::setId);
        Optional.ofNullable(contact.getType()).ifPresent(response::setType);
        Optional.ofNullable(contact.getInfo()).ifPresent(response::setInfo);
        return response;
    }

    public ContactResponse() {
    }

    public ContactResponse(String type, String info) {
        this.type = type;
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public ContactResponse setType(String type) {
        this.type = type;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public ContactResponse setInfo(String info) {
        this.info = info;
        return this;
    }
}
