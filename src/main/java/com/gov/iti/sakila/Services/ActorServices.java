package com.gov.iti.sakila.Services;

import com.gov.iti.sakila.presentation.dto.ActorDto;
import com.gov.iti.sakila.persistence.dao.ActorDao;
import com.gov.iti.sakila.persistence.entities.Actor;

import java.util.List;
import java.util.Optional;

public class ActorServices {

    private final ActorDao actorDao;

    public ActorServices() {
        this.actorDao = new ActorDao();
    }

    public Optional<ActorDto> getActorById(int id) {
        return actorDao.getActorById(id);
    }

    public void saveActor(Actor actor) {
        actorDao.save(actor);
    }

    public void updateActor(Actor actor) {
        actorDao.update(actor);
    }

    public void deleteActor(Actor actor) {
        actorDao.delete(actor);
    }

    public List<ActorDto> getAllActors() {
        return actorDao.getAllActors();
    }

    public List<ActorDto> getAllActorsByLimit(int start, int limit) {
        return actorDao.getAllActorsByLimit(start, limit);
    }

    public void deleteActorById(int id) {
        actorDao.deleteById(id);
    }
}
