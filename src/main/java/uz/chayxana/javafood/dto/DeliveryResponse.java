package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import uz.chayxana.javafood.delivery.Delivery;
import uz.chayxana.javafood.organization.Organization;

import java.io.Serializable;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryResponse implements Serializable {
    @JsonProperty("price")
    private Long price;
    @JsonProperty("extra_price")
    private Long extraPrice;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("end_time")
    private String endTime;

    public static DeliveryResponse entityToResponse(Delivery entity) {
        DeliveryResponse response = new DeliveryResponse();
        Optional.ofNullable(entity.getPrice()).ifPresent(response::setPrice);
        Optional.ofNullable(entity.getExtraPrice()).ifPresent(response::setExtraPrice);
        Optional.ofNullable(entity.getStartTime()).ifPresent(response::setStartTime);
        Optional.ofNullable(entity.getEndTime()).ifPresent(response::setEndTime);
        return response;
    }

    public DeliveryResponse() {
    }

    public DeliveryResponse(Long price, Long extraPrice, String startTime, String endTime) {
        this.price = price;
        this.extraPrice = extraPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getPrice() {
        return price;
    }

    public DeliveryResponse setPrice(Long price) {
        this.price = price;
        return this;
    }

    public Long getExtraPrice() {
        return extraPrice;
    }

    public DeliveryResponse setExtraPrice(Long extraPrice) {
        this.extraPrice = extraPrice;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public DeliveryResponse setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public DeliveryResponse setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }
}
