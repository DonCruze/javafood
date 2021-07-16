package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import uz.chayxana.javafood.delivery.Delivery;

import java.io.Serializable;
import java.util.Optional;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryResponse implements Serializable {
    @JsonProperty("id")
    private Long id;
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
        Optional.ofNullable(entity.getId()).ifPresent(response::setId);
        Optional.ofNullable(entity.getPrice()).ifPresent(response::setPrice);
        Optional.ofNullable(entity.getExtraPrice()).ifPresent(response::setExtraPrice);
        Optional.ofNullable(entity.getStartTime()).ifPresent(response::setStartTime);
        Optional.ofNullable(entity.getEndTime()).ifPresent(response::setEndTime);
        return response;
    }
}
