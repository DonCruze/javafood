package uz.chayxana.javafood.type;


import com.sun.istack.NotNull;
import lombok.Data;
import uz.chayxana.javafood.dto.TypeRequest;
import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "types")
    private Set<Organization> organizations = new HashSet<>();


    @Column(name = "trash")
    private Boolean trash = false;

    public Type() {
    }

    public Type setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
        return this;
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

    public Date getPostedAt() {
        return postedAt;
    }

    public Type setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
        return this;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public Type setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
        return this;
    }

    public Boolean getTrash() {
        return trash;
    }

    public Type setTrash(Boolean trash) {
        this.trash = trash;
        return this;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postedAt=" + postedAt +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", trash=" + trash +
                '}';
    }
}
