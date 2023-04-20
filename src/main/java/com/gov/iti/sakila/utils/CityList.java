package com.gov.iti.sakila.utils;

import com.gov.iti.sakila.presentation.dto.CityDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class CityList {


    private ArrayList<CityDto> cities;


    public CityList(ArrayList<CityDto> cities) {
        this.cities = cities;
    }

    public CityList() {
    }

    @XmlElement(name = "city")
    public ArrayList<CityDto> getCities() {
        return cities;
    }

    public void setCities(ArrayList<CityDto> cities) {
        this.cities = cities;
    }
}


