package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryRequest {
    @JsonProperty("price")
    private Long price;
    @JsonProperty("extraPrice")
    private Long extraPrice;
    @JsonProperty("star_time")
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

