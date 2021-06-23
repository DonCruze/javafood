package uz.chayxana.javafood.delivery;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
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
    @Column(name = "Organization_id")
    private Long organization_id;


    public Delivery() {
    }

    public Delivery(Long id, Long price, Long extraPrice, Time startTime, Time endTime, Long organization_id) {
        this.id = id;
        this.price = price;
        this.extraPrice = extraPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.organization_id = organization_id;
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

    public Long getOrganization_id() {
        return organization_id;
    }

    public Delivery setOrganization_id(Long organization_id) {
        this.organization_id = organization_id;
        return this;
    }
}
