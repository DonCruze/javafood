package uz.chayxana.javafood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OrganizationRequest implements Serializable {
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

    public OrganizationRequest() {
    }

    public OrganizationRequest(String name, Long starTime, Long endTime, String description, String latitude, String longitude, String logo) {
        this.name = name;
        this.starTime = starTime;
        this.endTime = endTime;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.logo = logo;
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
