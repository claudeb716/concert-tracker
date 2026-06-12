package com.pluralsight.concerttracker.data;

import com.pluralsight.concerttracker.entites.Promoter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoterRepository extends JpaRepository<Promoter, Long> {
}
