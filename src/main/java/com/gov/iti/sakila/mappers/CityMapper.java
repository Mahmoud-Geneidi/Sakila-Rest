package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.persistence.entities.City;
import com.gov.iti.sakila.presentation.dto.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CityMapper {

    @Mapping(source = "cityId" , target ="cityId")
    @Mapping(source = "city" , target ="city")
    @Mapping(source = "lastUpdate" , target ="lastUpdate")
    CityDto cityToCityDto(City city);

    @Mapping(source = "city" , target ="city")
    @Mapping(source = "country" , target ="country")
    @Mapping(source = "lastUpdate" , target ="lastUpdate")
    City cityDtoToCity(CityDto cityDto);


}
