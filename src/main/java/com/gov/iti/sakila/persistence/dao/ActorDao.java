package com.gov.iti.sakila.persistence.dao;

import com.gov.iti.sakila.presentation.dto.ActorDto;
import com.gov.iti.sakila.mappers.ActorMapper;

import com.gov.iti.sakila.persistence.Database;
import com.gov.iti.sakila.persistence.entities.Actor;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActorDao extends GenericDao<Actor> {


    public ActorMapper actorMapper = Mappers.getMapper(ActorMapper.class);
    public ActorDao() {

        super(Actor.class);

    }


    public Optional<ActorDto> getActorById(int id) {
        Optional<Actor> actorOptional = super.getById(id);
        return actorOptional.map(actorMapper::actorToActorDto);

    }

    public void save(ActorDto actor) {
        super.save(actorMapper.actorDtoToActor(actor));
    }

    public void update(ActorDto actor) {
        super.update(actorMapper.actorDtoToActor(actor));
    }

    public void delete(ActorDto actor) {
        super.delete(actorMapper.actorDtoToActor(actor));
    }

    public List<ActorDto> getAllActors() {
        return getAll().stream()
                .map(actorMapper::actorToActorDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ActorDto> getAllActorsByLimit(int start, int limit) {
        List<Actor> actors = getAll();
        int endIndex = Math.min(start + limit, actors.size());
        return actors.subList(start, endIndex).stream()
                .map(actorMapper::actorToActorDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void deleteById(int id) {
        Optional<Actor> actorOptional = getById(id);
        actorOptional.ifPresent(actor -> Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.remove(entityManager.contains(actor) ? actor : entityManager.merge(actor));
        }));
    }

}


