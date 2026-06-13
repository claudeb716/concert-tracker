package com.pluralsight.concerttracker.entites;

import jakarta.persistence.*;


@Entity
public class Venue {
    //Fields
    private String venueName;
    private String venueCity;
    private  int venueCapacity;
    //(Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // Constructors
    public Venue() {
    }
    public Venue(String name, String city, int capacity) {
        this.venueName = name;
        this.venueCity = city;
        this.venueCapacity = capacity;
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
