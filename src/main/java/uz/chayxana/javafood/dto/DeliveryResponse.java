package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.organization.Organization;

import java.io.Serializable;
import java.sql.Time;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryResponse implements Serializable {
    @JsonProperty("Price")
    private Long price;
    @JsonProperty("ExtraPrice")
    private Long extraPrice;
    @JsonProperty("start_time")
    private Time startTime;
    @JsonProperty("end_time")
    private Time endTime;

    public static DeliveryResponse entityToResponse(Delivery entity) {
        DeliveryResponse response = new DeliveryResponse();
        Optional.ofNullable(entity.getPrice()).ifPresent(s -> response.setPrice(s));
        Optional.ofNullable(entity.getExtraPrice()).ifPresent(s -> response.setExtraPrice(s));
        Optional.ofNullable(entity.getStartTime()).ifPresent(s -> response.setStartTime(s));
        Optional.ofNullable(entity.getEndTime()).ifPresent(s -> response.setendTime(s));
        return response;
    }

    public DeliveryResponse() {
    }

    public DeliveryResponse(Long price, Long extraPrice, Time startTime, Time endTime) {
        this.price = price;
        this.extraPrice = extraPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getExtraPrice() {
        return price;
    }

    public void setExtraPrice(Long extraPrice) {
        this.extraPrice = extraPrice;
    }

    public Time startTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setendTime(Time price) { this.endTime = endTime; }

}
