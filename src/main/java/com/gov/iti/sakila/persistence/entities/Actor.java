package com.gov.iti.sakila.persistence.entities;// default package
// Generated Apr 7, 2023, 4:05:26 PM by Hibernate Tools 6.1.7.Final


import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Actor generated by hbm2java
 */
@Entity
@Table(name="actor"
    ,catalog="sakila"
)
public class Actor  implements java.io.Serializable {


     private Short actorId;
     private String firstName;
     private String lastName;
     private Date lastUpdate;


     private Set<FilmActor> filmActors = new HashSet<FilmActor>(0);

    public Actor() {
    }

	
    public Actor(String firstName, String lastName, Date lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }
    public Actor(String firstName, String lastName, Date lastUpdate, Set<FilmActor> filmActors) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.lastUpdate = lastUpdate;
       this.filmActors = filmActors;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="actor_id", unique=true, nullable=false)
    public Short getActorId() {
        return this.actorId;
    }
    
    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    
    @Column(name="first_name", nullable=false, length=45)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", nullable=false, length=45)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="actor", cascade = CascadeType.ALL)
    public Set<FilmActor> getFilmActors() {
        return this.filmActors;
    }
    
    public void setFilmActors(Set<FilmActor> filmActors) {
        this.filmActors = filmActors;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", filmActors=" + filmActors +
                '}';
    }
}


