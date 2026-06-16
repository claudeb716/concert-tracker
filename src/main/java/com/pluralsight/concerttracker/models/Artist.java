package com.pluralsight.concerttracker.models;

import jakarta.persistence.*;


@Entity
public class Artist {
    //Fields
    private String artistName;
    private String genre;
    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Constructors
    public Artist() {
    }
    public Artist(String name, String genre) {
        this.artistName = name;
        this.genre = genre;
    }
//Getters and Setters
    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String name) {
        this.artistName = name;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
