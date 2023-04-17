package com.gov.iti.sakila.presentation.controllers;

import com.gov.iti.sakila.Services.FilmServices;
import com.gov.iti.sakila.presentation.dto.FilmDto;
import com.gov.iti.sakila.utils.FilmList;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Optional;

@Path("/films")
public class FilmWebServices {

    private FilmServices filmServices = new FilmServices();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmById(@PathParam("id") short id) {
        Optional<FilmDto> optionalFilmDto = filmServices.getFilmById(id);
        FilmDto filmDto = optionalFilmDto.orElse(null);
        if (filmDto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(filmDto).build();
        }
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveFilm(FilmDto film) {
        if (film == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            filmServices.save(film);
            return Response.ok(true).build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFilm(FilmDto film) {
        filmServices.update(film);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteFilm(FilmDto film) {
        filmServices.delete(film);
        return Response.ok().build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilms() {
        ArrayList<FilmDto> films = (ArrayList<FilmDto>) filmServices.getAllFilms();
        FilmList filmList = new FilmList(films);
        return Response.ok(filmList).build();
    }

    @GET
    @Path("/limit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilmsByLimit(@QueryParam("start") int start, @QueryParam("limit") int limit) {
        ArrayList<FilmDto> films = (ArrayList<FilmDto>) filmServices.getAllFilmsByLimit(start, limit);
        FilmList filmList = new FilmList(films);
        return Response.ok(filmList).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteFilmById(@PathParam("id") short id) {
        Optional<FilmDto> optionalFilmDto = filmServices.getFilmById(id);
        FilmDto filmDto = optionalFilmDto.orElse(null);
        if (filmDto != null) {
            filmServices.deleteById(id);
            return Response.ok(true).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
