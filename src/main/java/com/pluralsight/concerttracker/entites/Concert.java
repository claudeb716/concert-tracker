package com.pluralsight.concerttracker.entites;

import jakarta.persistence.*;

@Entity
public class Concert {
    //Fields
    private int concerYear;
    private int ticketSold;
    private double ticketPrice;
    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //OneToOne Relationships
    @OneToOne
    private Venue concertVenue;
    @OneToOne
    private Artist concertArtist;
    @OneToOne
    private Promoter concertPromoter;
    //Constructors
    public Concert() {
    }
    public Concert(int year,int sold, double price, Venue v, Artist a, Promoter p) {
        this.concerYear = year;
        this.ticketSold = sold;
        this.ticketPrice = price;
        this.concertVenue = v;
        this.concertArtist = a;
        this.concertPromoter = p;
    }
//Getters and Setters
    public int getConcerYear() {
        return concerYear;
    }
    public void setConcerYear(int year) {
        this.concerYear = year;
    }

    public int getTicketSold() {
        return ticketSold;
    }
    public void setTicketSold(int sold) {
        this.ticketSold = sold;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double price) {
        this.ticketPrice = price;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Venue getConcertVenue() {
        return concertVenue;
    }
    public void setConcertVenue(Venue v) {
        this.concertVenue = v;
    }

    public Artist getConcertArtist() {
        return concertArtist;
    }
    public void setConcertArtist(Artist a) {
        this.concertArtist = a;
    }

    public Promoter getConcertPromoter() {
        return concertPromoter;
    }
    public void setConcertPromoter(Promoter p) {
        this.concertPromoter = p;
    }
}
