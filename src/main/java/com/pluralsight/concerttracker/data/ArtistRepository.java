package com.pluralsight.concerttracker.data;

import com.pluralsight.concerttracker.entites.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
