package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.presentation.dto.FilmDto;
import com.gov.iti.sakila.persistence.entities.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FilmMapper {

    @Mapping(source = "filmId" , target ="filmId")
    @Mapping(source = "title" , target ="title")
    @Mapping(source = "description" , target ="description")
    @Mapping(source = "releaseYear" , target ="releaseYear")
    @Mapping(source = "rentalDuration" , target ="rentalDuration")
    @Mapping(source = "rentalRate" , target ="rentalRate")
    @Mapping(source = "length" , target ="length")
    @Mapping(source = "replacementCost" , target ="replacementCost")
    @Mapping(source = "rating" , target ="rating")
    @Mapping(source = "specialFeatures" , target ="specialFeatures")
    @Mapping(source = "lastUpdate" , target ="lastUpdate")
    FilmDto filmToFilmDto(Film film);

    @Mapping(source = "filmId" , target ="filmId")
    @Mapping(source = "title" , target ="title")
    @Mapping(source = "description" , target ="description")
    @Mapping(source = "releaseYear" , target ="releaseYear")
    @Mapping(source = "rentalDuration" , target ="rentalDuration")
    @Mapping(source = "rentalRate" , target ="rentalRate")
    @Mapping(source = "length" , target ="length")
    @Mapping(source = "replacementCost" , target ="replacementCost")
    @Mapping(source = "rating" , target ="rating")
    @Mapping(source = "specialFeatures" , target ="specialFeatures")
    @Mapping(source = "lastUpdate" , target ="lastUpdate")
    @Mapping(source = "languageByLanguageId" , target ="languageByLanguageId")
    Film filmDtoToFilm(FilmDto film);



}
