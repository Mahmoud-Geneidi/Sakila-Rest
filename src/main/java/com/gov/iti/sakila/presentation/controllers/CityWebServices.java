package com.gov.iti.sakila.presentation.controllers;

import com.gov.iti.sakila.Services.CityServices;
import com.gov.iti.sakila.presentation.dto.CityDto;
import com.gov.iti.sakila.utils.CityList;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Optional;

@Path("/cities")
public class CityWebServices {

    private CityServices cityServices = new CityServices();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityById(@PathParam("id") short id) {
        Optional<CityDto> optionalCityDto = cityServices.getCityById(id);
        CityDto cityDto = optionalCityDto.orElse(null);
        if (cityDto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(cityDto).build();
        }
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCity(CityDto city) {
        if (city == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            cityServices.saveCity(city);
            return Response.ok(true).build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCity(CityDto city) {
        cityServices.updateCity(city);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCity(CityDto city) {
        cityServices.deleteCity(city);
        return Response.ok().build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCities() {
        ArrayList<CityDto> cities = (ArrayList<CityDto>) cityServices.getAllCities();
        CityList cityList = new CityList(cities);
        return Response.ok(cityList).build();
    }

    @GET
    @Path("/limit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCitiesByLimit(@QueryParam("start") int start, @QueryParam("limit") int limit) {
        ArrayList<CityDto> cities = (ArrayList<CityDto>) cityServices.getAllCitiesByLimit(start, limit);
        CityList cityList = new CityList(cities);
        return Response.ok(cityList).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteCityById(@PathParam("id") short id) {
        Optional<CityDto> optionalCityDto = cityServices.getCityById(id);
        CityDto cityDto = optionalCityDto.orElse(null);
        if (cityDto != null) {
            cityServices.deleteCity(cityDto);
            return Response.ok(true).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
