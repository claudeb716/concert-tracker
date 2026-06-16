package com.pluralsight.concerttracker.models;

import jakarta.persistence.*;

@Entity
public class Promoter {
    //Fields
    private String promoterName;
    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Constructors
    public Promoter() {
    }
    public Promoter(String name) {
        this.promoterName = name;
    }
//Getters and Setters
    public String getPromoterName() {
        return promoterName;
    }
    public void setPromoterName(String name) {
        this.promoterName = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
