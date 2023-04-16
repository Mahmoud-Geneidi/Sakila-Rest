package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.presentation.dto.ActorDto;
import com.gov.iti.sakila.persistence.entities.Actor;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-07T19:50:39+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class ActorMapperImpl implements ActorMapper {

    @Override
    public ActorDto actorToActorDto(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorDto actorDto = new ActorDto();

        actorDto.setActorId( actor.getActorId() );
        actorDto.setFirstName( actor.getFirstName() );
        actorDto.setLastName( actor.getLastName() );
        actorDto.setLastUpdate( actor.getLastUpdate() );

        return actorDto;
    }
}
