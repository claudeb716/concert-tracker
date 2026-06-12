package com.pluralsight.concerttracker.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venue {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //(Primary Key)

    private String venueName;
    private String venueCity;
    private  int venueCapacity;
    // Constructors
    public Venue() {
    }
    public Venue(String venueName, String venueCity, int venueCapacity) {
        this.venueName = venueName;
        this.venueCity = venueCity;
        this.venueCapacity = venueCapacity;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getVenueName() {
        return venueName;
    }
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueCity() {
        return venueCity;
    }
    public void setVenueCity(String venueCity) {
        this.venueCity = venueCity;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }
    public void setVenueCapacity(int venueCapacity) {
        this.venueCapacity = venueCapacity;
    }
}
