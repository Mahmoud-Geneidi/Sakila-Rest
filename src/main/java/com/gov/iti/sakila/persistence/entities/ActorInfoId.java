package com.gov.iti.sakila.persistence.entities;// default package
// Generated Apr 7, 2023, 4:05:26 PM by Hibernate Tools 6.1.7.Final


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * ActorInfoId generated by hbm2java
 */
@Embeddable
public class ActorInfoId  implements java.io.Serializable {


     private short actorId;
     private String filmInfo;
     private String firstName;
     private String lastName;

    public ActorInfoId() {
    }

	
    public ActorInfoId(short actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public ActorInfoId(short actorId, String filmInfo, String firstName, String lastName) {
       this.actorId = actorId;
       this.filmInfo = filmInfo;
       this.firstName = firstName;
       this.lastName = lastName;
    }
   


    @Column(name="actor_id", nullable=false)
    public short getActorId() {
        return this.actorId;
    }
    
    public void setActorId(short actorId) {
        this.actorId = actorId;
    }


    @Column(name="film_info", length=65535)
    public String getFilmInfo() {
        return this.filmInfo;
    }
    
    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ActorInfoId) ) return false;
		 ActorInfoId castOther = ( ActorInfoId ) other; 
         
		 return (this.getActorId()==castOther.getActorId())
 && ( (this.getFilmInfo()==castOther.getFilmInfo()) || ( this.getFilmInfo()!=null && castOther.getFilmInfo()!=null && this.getFilmInfo().equals(castOther.getFilmInfo()) ) )
 && ( (this.getFirstName()==castOther.getFirstName()) || ( this.getFirstName()!=null && castOther.getFirstName()!=null && this.getFirstName().equals(castOther.getFirstName()) ) )
 && ( (this.getLastName()==castOther.getLastName()) || ( this.getLastName()!=null && castOther.getLastName()!=null && this.getLastName().equals(castOther.getLastName()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getActorId();
         result = 37 * result + ( getFilmInfo() == null ? 0 : this.getFilmInfo().hashCode() );
         result = 37 * result + ( getFirstName() == null ? 0 : this.getFirstName().hashCode() );
         result = 37 * result + ( getLastName() == null ? 0 : this.getLastName().hashCode() );
         return result;
   }   


}


