package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Time;

public class DeliveryRequest implements Serializable {
    @JsonProperty("Price")
    private Long price;
    @JsonProperty("ExtraPrice")
    private Long extraPrice;
    @JsonProperty("start_time")
    private Time starTime;
    @JsonProperty("end_time")
    private Time endTime;

    public DeliveryRequest() {
    }

    public DeliveryRequest(Long price, Long extraPrice, Time starTime, Time endTime) {
        this.price = price;
        this.extraPrice = extraPrice;
        this.starTime = starTime;
        this.endTime = endTime;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(Long extraPrice) {
        this.extraPrice = extraPrice;
    }

    public Time getStarTime() {
        return starTime;
    }

    public void setStarTime(Time starTime) {
        this.starTime = starTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

}