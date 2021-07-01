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
    private String starTime;
    @JsonProperty("end_time")
    private String endTime;


    public DeliveryRequest() {
    }

    public DeliveryRequest(Long price, Long extraPrice, String starTime, String endTime) {
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

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}