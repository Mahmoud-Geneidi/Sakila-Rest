package com.gov.iti.sakila.mappers;


import com.gov.iti.sakila.persistence.entities.City;
import com.gov.iti.sakila.presentation.dto.CityDto;

public class CityMapperImpl implements CityMapper {
    @Override
    public CityDto cityToCityDto(City city) {
        CityDto cityDto = new CityDto();
        if (city != null) {
            cityDto.setCityId(city.getCityId());
            cityDto.setCity(city.getCity());
            cityDto.setLastUpdate(city.getLastUpdate());
        }
        return cityDto;
    }

    @Override
    public City cityDtoToCity(CityDto cityDto) {
        City city = new City();
        if (cityDto != null) {
            city.setCountry(cityDto.getCountry());
            city.setCity(cityDto.getCity());
            city.setLastUpdate(cityDto.getLastUpdate());
        }
        return city;
    }
}
