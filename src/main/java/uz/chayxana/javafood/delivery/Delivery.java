package uz.chayxana.javafood.delivery;

import uz.chayxana.javafood.organization.Organization;

import javax.persistence.*;
import java.sql.Time;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public Delivery() {
    }

    public Delivery(Long id, Long price, Long extraPrice, Time startTime, Time endTime, Organization organization) {
        this.id = id;
        this.price = price;
        this.extraPrice = extraPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.organization = organization;
    }

    public Delivery setOrganization(Organization organization_id) {
        this.organization = organization_id;
        return this;
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
}
