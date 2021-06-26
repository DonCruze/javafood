package uz.chayxana.javafood.dto;

public class ContactRequest {
    private String type;
    private String info;

    public ContactRequest() {
    }

    public ContactRequest(String type, String info) {
        this.type = type;
        this.info = info;
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

    public String getInfo() {
        return info;
    }

    public ContactRequest setInfo(String info) {
        this.info = info;
        return this;
    }
}
