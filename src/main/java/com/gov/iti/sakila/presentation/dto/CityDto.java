package com.gov.iti.sakila.presentation.dto;

import com.gov.iti.sakila.persistence.entities.Country;

import java.io.Serializable;
import java.util.Date;

public class CityDto implements Serializable {
    private Short cityId;
    private Country country;
    private String city;
    private Date lastUpdate;

    public CityDto() {
    }

    public CityDto(String city, Date lastUpdate) {
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public CityDto(Short cityId, String city, Date lastUpdate) {
        this.cityId = cityId;
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public CityDto(Country country, String city, Date lastUpdate) {
        this.country = country;
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public Short getCityId() {
        return cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "cityId=" + cityId +
                ", country=" + country +
                ", city='" + city + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
