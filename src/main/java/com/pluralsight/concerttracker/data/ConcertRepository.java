package com.pluralsight.concerttracker.data;


import com.pluralsight.concerttracker.models.Concert;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    List<Concert> findByConcertVenue_VenueName(String name);
    List<Concert> findByMinimumCapacity(int size);
    List<Concert> findByConcertArtist_ArtistName(String name);
    List<Concert> findByConcertPromoter_PromoterName(String name);

    List<Concert>findByTicketsSold(int text);

    List<Concert> findByTicketPrice(double price);

    List<Concert>findByConcertYear(int year);
}
