package com.pluralsight.concerttracker.data;


import com.pluralsight.concerttracker.models.Concert;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {



    //manage concert
    List<Concert>findByTicketsSold(int text);
    List<Concert> findByTicketPrice(double price);
    List<Concert>findByConcertYear(int year);
}
