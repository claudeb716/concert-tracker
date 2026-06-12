package com.pluralsight.concerttracker.data;

import com.pluralsight.concerttracker.entites.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
