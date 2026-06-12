package com.pluralsight.concerttracker.data;

import com.pluralsight.concerttracker.entites.Artist;
import com.pluralsight.concerttracker.entites.Concert;
import com.pluralsight.concerttracker.entites.Promoter;
import com.pluralsight.concerttracker.entites.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    List<Venue> findByVenue_Name(String name);
    List<Artist> findByArtist_Name(String name);
    List<Promoter> findByPromoter_Name(String name);
}
