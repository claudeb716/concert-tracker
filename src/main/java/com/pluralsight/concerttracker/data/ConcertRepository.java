package com.pluralsight.concerttracker.data;


import com.pluralsight.concerttracker.models.Concert;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    //Manage venues
    List<Concert> findBy_VenueName(String name);
    List<Concert> findBy_VenueCity(String city);
    List<Concert> findByMinimumCapacity(int size);
    //manage artist
    List<Concert> findBy_Genre(String genre);
    List<Concert> findBy_ArtistName(String name);
    //manage promoter
    List<Concert> findBy_PromoterName(String name);
    //manage concert
    List<Concert>findByTicketsSold(int text);
    List<Concert> findByTicketPrice(double price);
    List<Concert>findByConcertYear(int year);
}
