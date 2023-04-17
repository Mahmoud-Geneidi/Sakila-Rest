package com.gov.iti.sakila.presentation.controllers;

import com.gov.iti.sakila.Services.ActorServices;
import com.gov.iti.sakila.presentation.dto.ActorDto;
import com.gov.iti.sakila.utils.ActorList;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.Optional;


    @Path("/actors")
    public class ActorWebServices {

        private ActorServices actorServices = new ActorServices();

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getActorById(@PathParam("id") short id) {
            Optional<ActorDto> optionalActorDto = actorServices.getActorById(id);
            ActorDto actorDto = optionalActorDto.orElse(null);
            if (actorDto == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                return Response.ok(actorDto).build();
            }
        }

        @POST
        @Path("/save")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response saveActor(ActorDto actor) {
            if (actor == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            } else {
                actorServices.saveActor(actor);
                return Response.ok(true).build();
            }
        }

        @PUT
        @Path("/update")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response updateActor(ActorDto actor) {
            actorServices.updateActor(actor);
            return Response.ok().build();
        }

        @DELETE
        @Path("/delete")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response deleteActor(ActorDto actor) {
            actorServices.deleteActor(actor);
            return Response.ok().build();
        }

        @GET
        @Path("/getAll")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getAllActors() {
            ArrayList<ActorDto> actors = (ArrayList<ActorDto>) actorServices.getAllActors();
            ActorList actorList = new ActorList(actors);
            return Response.ok(actorList).build();
        }

        @GET
        @Path("/limit")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getAllActorsByLimit(@QueryParam("start") int start, @QueryParam("limit") int limit) {
            ArrayList<ActorDto> actors = (ArrayList<ActorDto>) actorServices.getAllActorsByLimit(start, limit);
            ActorList actorList = new ActorList(actors);
            return Response.ok(actorList).build();
        }

        @DELETE
        @Path("/delete/{id}")
        public Response deleteActorById(@PathParam("id") short id) {
            Optional<ActorDto> optionalActorDto = actorServices.getActorById(id);
            ActorDto actorDto = optionalActorDto.orElse(null);
            if (actorDto != null) {
                actorServices.deleteActor(actorDto);
                return Response.ok(true).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }
    }


