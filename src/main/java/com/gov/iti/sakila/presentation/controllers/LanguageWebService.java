package com.gov.iti.sakila.presentation.controllers;

import com.gov.iti.sakila.Services.LanguageServices;
import com.gov.iti.sakila.presentation.dto.LanguageDto;
import com.gov.iti.sakila.persistence.entities.Language;
import com.gov.iti.sakila.utils.LanguageList;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.util.ArrayList;
import java.util.Optional;

@Path("/languages")
public class LanguageWebService {

    private LanguageServices languageServices = new LanguageServices();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLanguageById(@PathParam("id") short id) {
        Optional<LanguageDto> optionalLanguageDto = languageServices.getLanguageById(id);
        LanguageDto languageDto = optionalLanguageDto.orElse(null);
        if (languageDto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(languageDto).build();
        }
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveLanguage(LanguageDto language) {
        if (language == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            languageServices.saveLanguage(language);
            return Response.ok(true).build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateLanguage(LanguageDto language) {
        languageServices.updateLanguage(language);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteLanguage(LanguageDto language) {
        languageServices.deleteLanguage(language);
        return Response.ok().build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLanguages() {
        ArrayList<LanguageDto> languages = (ArrayList<LanguageDto>) languageServices.getAllLanguages();
        LanguageList languageList = new LanguageList(languages);
        return Response.ok(languageList).build();
    }

    @GET
    @Path("/limit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLanguagesByLimit(@QueryParam("start") int start, @QueryParam("limit") int limit) {
        ArrayList<LanguageDto> languages = (ArrayList<LanguageDto>) languageServices.getAllLanguagesByLimit(start, limit);
        LanguageList languageList = new LanguageList(languages);
        return Response.ok(languageList).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteLanguageById(@PathParam("id") short id) {
        Optional<LanguageDto> optionalLanguageDto = languageServices.getLanguageById(id);
        LanguageDto languageDto = optionalLanguageDto.orElse(null);
        if (languageDto != null) {
            languageServices.deleteLanguage(languageDto);
            return Response.ok(true).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
