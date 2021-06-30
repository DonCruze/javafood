package uz.chayxana.javafood.delivery;

import uz.chayxana.javafood.dto.DeliveryRequest;
import uz.chayxana.javafood.dto.OrganizationRequest;
import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.sql.Time;
import java.util.Optional;

@Entity
@Table(name = "Delivery")
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Price")
    private Long price;
    @Column(name = "ExtraPrice")
    private Long extraPrice;
    @Column(name = "StartTime")
    private Time startTime;
    @Column(name = "EndTime")
    private Time endTime;

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

    public Time getStartTime() {
        return startTime;
    }

    public Delivery setStartTime(Time startTime) {
        this.startTime = startTime;
        return this;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Delivery setEndTime(Time endTime) {
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
}
