package uz.chayxana.javafood.delivery;

import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.OrganizationRequest;
import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "Delivery")
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "price")
    private Long price;
    @Column(name = "extra_price")
    private Long extraPrice;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;

    @Column(name = "trash")
    private Boolean trash = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public Delivery() {
    }

    public static Delivery reqToEntity(DeliveryRequest req) {
        return reqToEntity(new Delivery(), req);
    }

    public static Delivery reqToEntity(Delivery entity, DeliveryRequest req) {
        Optional.ofNullable(req.getPrice()).ifPresent(entity::setPrice);
        Optional.ofNullable(req.getExtraPrice()).ifPresent(entity::setExtraPrice);
        Optional.ofNullable(req.getStarTime()).ifPresent(entity::setStartTime);
        Optional.ofNullable(req.getEndTime()).ifPresent(entity::setEndTime);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public Delivery setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public Delivery setPrice(Long price) {
        this.price = price;
        return this;
    }

    public Long getExtraPrice() {
        return extraPrice;
    }

    public Delivery setExtraPrice(Long extraPrice) {
        this.extraPrice = extraPrice;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public Delivery setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public Delivery setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public Boolean getTrash() {
        return trash;
    }

    public Delivery setTrash(Boolean trash) {
        this.trash = trash;
        return this;
    }

    public Delivery setOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }
}
