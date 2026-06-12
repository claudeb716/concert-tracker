package com.pluralsight.concerttracker.service;

import com.pluralsight.concerttracker.data.ArtistRepository;
import com.pluralsight.concerttracker.data.ConcertRepository;
import com.pluralsight.concerttracker.data.PromoterRepository;
import com.pluralsight.concerttracker.data.VenueRepository;
import com.pluralsight.concerttracker.entites.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertService {
    //communicate to the repos
    private final ConcertRepository cr;
    private final PromoterRepository pr;
    private final ArtistRepository ar;
    private final VenueRepository vr;
    //Constructor Injection
@Autowired
    public ConcertService(ConcertRepository cr, PromoterRepository pr, ArtistRepository ar, VenueRepository vr) {
        this.cr = cr;
        this.pr = pr;
        this.ar = ar;
        this.vr = vr;
    }
    public void seedIfEmpty(){
    if (cr.count() > 0){
        return;
    }
        Venue citizensBankPark = vr.save(new Venue("Citizens Bank Park", "Philadelphia", 42901));
        Venue lincolnFinanicalField = vr.save(new Venue("Citizens Bank Park", "Philadelphia", 42901));
        Venue dellMusicCenter = vr.save(new Venue("Citizens Bank Park", "Philadelphia", 42901));
        Venue franklinMusicHall = vr.save(new Venue("Citizens Bank Park", "Philadelphia", 42901));
        Venue ardmoreMusicHall = vr.save(new Venue("Citizens Bank Park", "Philadelphia", 42901));
        Venue grandOperaHouse = vr.save(new Venue("Citizens Bank Park", "Philadelphia", 42901));
        Venue whiteEagleHall = vr.save(new Venue("Citizens Bank Park", "Philadelphia", 42901));

    }
    public String getStatus(){
    return "Concerts are Loading...";
    }
}
