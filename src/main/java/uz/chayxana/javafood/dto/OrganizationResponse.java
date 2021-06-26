package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import uz.chayxana.javafood.organization.Organization;

import java.io.Serializable;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationResponse implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("start_time")
    private Long starTime;
    @JsonProperty("end_time")
    private Long endTime;
    @JsonProperty("description")
    private String description;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("logo_url")
    private String logo;

    public static OrganizationResponse entityToResponse(Organization entity) {
        OrganizationResponse response = new OrganizationResponse();
        Optional.ofNullable(entity.getId()).ifPresent(s -> response.setId(s));
        Optional.ofNullable(entity.getName()).ifPresent(s -> response.setName(s));
        Optional.ofNullable(entity.getDescription()).ifPresent(response::setDescription);
        Optional.ofNullable(entity.getLogo()).ifPresent(response::setLogo);
        StringBuilder location = new StringBuilder();
//        Optional.ofNullable(entity.getLocation()).ifPresent(s -> location.append(s));
//        String[] loc = location.toString().split(",");
//        String lat = loc[0].replace("lat:", "");
//        response.setLatitude(lat);
//        String lon = loc[1].replace("lon:", "");
//        response.setLongitude(lon);
//        entity.setLocation(location.toString());
        Optional.ofNullable(entity.getLongitude()).ifPresent(response::setLongitude);
        Optional.ofNullable(entity.getLatitude()).ifPresent(response::setLatitude);
        Optional.ofNullable(entity.getStarTime()).ifPresent(response::setStarTime);
        Optional.ofNullable(entity.getEndTime()).ifPresent(response::setEndTime);
        return response;
    }

    public OrganizationResponse() {
    }

    public OrganizationResponse(Long id, String name, Long starTime, Long endTime, String description, String latitude, String longitude, String logo) {
        this.id = id;
        this.name = name;
        this.starTime = starTime;
        this.endTime = endTime;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStarTime() {
        return starTime;
    }

    public void setStarTime(Long starTime) {
        this.starTime = starTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
