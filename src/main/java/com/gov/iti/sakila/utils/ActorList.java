package com.gov.iti.sakila.utils;

import com.gov.iti.sakila.presentation.dto.ActorDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class ActorList {
    private ArrayList<ActorDto> actors;

    public ActorList() {
    }

    public ActorList(ArrayList<ActorDto> actors) {
        this.actors = actors;
    }

    @XmlElement(name="actor")
    public ArrayList<ActorDto> getActors() {
        return actors;
    }

    public void setActors(ArrayList<ActorDto> actors) {
        this.actors = actors;
    }
}
