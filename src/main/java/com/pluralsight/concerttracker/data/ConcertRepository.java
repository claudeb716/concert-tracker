package com.pluralsight.concerttracker.data;


import com.pluralsight.concerttracker.entites.Concert;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    List<Concert> findByVenue_Name(String name);
    List<Concert> findByArtist_Name(String name);
    List<Concert> findByPromoter_Name(String name);

    List<Concert>findByTicketSold(int text);

    List<Concert> findByTicketPrice(double price);

    List<Concert>findByConcertYear(int year);
}
