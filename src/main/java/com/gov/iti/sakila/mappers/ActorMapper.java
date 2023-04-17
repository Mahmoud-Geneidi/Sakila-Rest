package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.presentation.dto.ActorDto;
import com.gov.iti.sakila.persistence.entities.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ActorMapper {
    @Mapping(source = "actorId",target = "actorId")
    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    @Mapping(source = "lastUpdate",target = "lastUpdate")
    ActorDto actorToActorDto(Actor actor);

    @Mapping(source = "actorId",target = "actorId")
    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    @Mapping(source = "lastUpdate",target = "lastUpdate")

    Actor actorDtoToActor(ActorDto actor);
}
