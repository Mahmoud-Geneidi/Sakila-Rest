//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.presentation.dto.FilmDto;
import com.gov.iti.sakila.persistence.entities.Film;

public class FilmMapperImpl implements FilmMapper {

    @Override
    public FilmDto filmToFilmDto(Film film) {
        if (film == null) {
            return null;
        } else {
            FilmDto filmDto = new FilmDto();
            filmDto.setFilmId(film.getFilmId());
            filmDto.setTitle(film.getTitle());
            filmDto.setDescription(film.getDescription());
            filmDto.setReleaseYear(film.getReleaseYear());
            filmDto.setRentalDuration(film.getRentalDuration());
            filmDto.setRentalRate(film.getRentalRate());
            filmDto.setLength(film.getLength());
            filmDto.setReplacementCost(film.getReplacementCost());
            filmDto.setRating(film.getRating());
            filmDto.setSpecialFeatures(film.getSpecialFeatures());
            filmDto.setLastUpdate(film.getLastUpdate());
            return filmDto;
        }
    }

    @Override
    public Film filmDtoToFilm(FilmDto film) {
        Film film1 = new Film();
        film1.setFilmId(film.getFilmId());
        film1.setTitle(film.getTitle());
        film1.setDescription(film.getDescription());
        film1.setReleaseYear(film.getReleaseYear());
        film1.setRentalDuration(film.getRentalDuration());
        film1.setRentalRate(film.getRentalRate());
        film1.setLength(film.getLength());
        film1.setReplacementCost(film.getReplacementCost());
        film1.setRating(film.getRating());
        film1.setSpecialFeatures(film.getSpecialFeatures());
        film1.setLastUpdate(film.getLastUpdate());
        film1.setLanguageByLanguageId(film.getLanguageByLanguageId());
        return film1;
    }
}
