package com.pluralsight.concerttracker.data;

import com.pluralsight.concerttracker.models.Artist;
import com.pluralsight.concerttracker.models.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    //manage artist
    List<Artist> findByGenre(String genre);
    List<Artist> findByNameContaining(String name);
}
