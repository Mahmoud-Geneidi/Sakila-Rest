package com.gov.iti.sakila.utils;

import com.gov.iti.sakila.presentation.dto.FilmDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class FilmList {
    private ArrayList<FilmDto> films;

    public FilmList() {
    }

    public FilmList(ArrayList<FilmDto> films) {
        this.films = films;
    }

    @XmlElement(name="film")
    public ArrayList<FilmDto> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<FilmDto> films) {
        this.films = films;
    }
}
