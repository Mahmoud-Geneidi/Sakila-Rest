package com.gov.iti.sakila.persistence.dao;


import com.gov.iti.sakila.mappers.CityMapper;
import com.gov.iti.sakila.persistence.Database;
import com.gov.iti.sakila.persistence.entities.City;
import com.gov.iti.sakila.presentation.dto.CityDto;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CityDao extends GenericDao<City> {

    public CityMapper cityMapper = Mappers.getMapper(CityMapper.class);

    public CityDao() {
        super(City.class);
    }

    public Optional<CityDto> getCityById(Short id) {
        Optional<City> cityOptional = super.getById( id);
        return cityOptional.map(cityMapper::cityToCityDto);
    }

    public void save(CityDto cityDto) {
        super.save(cityMapper.cityDtoToCity(cityDto));
    }

    public void update(CityDto cityDto) {
        super.update(cityMapper.cityDtoToCity(cityDto));
    }

    public void delete(CityDto cityDto) {
        super.delete(cityMapper.cityDtoToCity(cityDto));
    }


    public List<CityDto> getAllCities() {
        return getAll().stream()
                .map(cityMapper::cityToCityDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<CityDto> getAllCitiesByLimit(int start, int limit) {
        List<City> cities = super.getAll();
        int endIndex = Math.min(start + limit, cities.size());
        return cities.subList(start, endIndex).stream()
                .map(cityMapper::cityToCityDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void deleteById(Short id) {
        Optional<CityDto> cityOptional = getCityById(id);
        System.out.println("-------------------------------"+cityOptional.orElse(null));
        cityOptional.ifPresent(city -> Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.remove(entityManager.contains(cityMapper.cityDtoToCity(city)) ? cityMapper.cityDtoToCity(city) : entityManager.merge(cityMapper.cityDtoToCity(city)));
        }));
    }
}
