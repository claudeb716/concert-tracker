package com.pluralsight.concerttracker.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    public Promoter(String promoterName) {
        this.promoterName = promoterName;
    }
//Getters and Setters
    public String getPromoterName() {
        return promoterName;
    }
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
