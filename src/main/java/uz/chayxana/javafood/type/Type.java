package uz.chayxana.javafood.type;


import uz.chayxana.javafood.dto.TypeRequest;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "trash")
    private Boolean trash = false;

    public Type() {
    }

    public static Type reqToEntity(TypeRequest req) {
        return reqToEntity(new Type(), req);
    }

    public static Type reqToEntity(Type entity, TypeRequest req) {
        Optional.ofNullable(req.getName()).ifPresent(entity::setName);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public Type setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Type setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getTrash() {
        return trash;
    }

    public Type setTrash(Boolean trash) {
        this.trash = trash;
        return this;
    }
}
