package com.gov.iti.sakila.persistence.dao;

import com.gov.iti.sakila.presentation.dto.FilmDto;
import com.gov.iti.sakila.mappers.FilmMapper;

import com.gov.iti.sakila.persistence.Database;
import com.gov.iti.sakila.persistence.entities.Film;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilmDao extends GenericDao<Film> {

    public FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);

    public FilmDao() {
        super(Film.class);
    }

    public Optional<FilmDto> getFilmById(int id) {
        Optional<Film> filmOptional = super.getById(id);
        return filmOptional.map(filmMapper::filmToFilmDto);
    }

    public void save(Film film) {
        super.save(film);
    }

    public void update(Film film) {
        super.update(film);
    }

    public void delete(FilmDto film) {
        super.delete(filmMapper.filmDtoToFilm(film));
    }

    public List<FilmDto> getAllFilms() {
        return getAll().stream()
                .map(filmMapper::filmToFilmDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<FilmDto> getAllFilmsByLimit(int start, int limit) {
        List<Film> films = getAll();
        int endIndex = Math.min(start + limit, films.size());
        return films.subList(start, endIndex).stream()
                .map(filmMapper::filmToFilmDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void deleteById(int id) {
        Optional<Film> filmOptional = getById(id);
        filmOptional.ifPresent(film -> Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.remove(entityManager.contains(film) ? film : entityManager.merge(film));
        }));
    }
}
