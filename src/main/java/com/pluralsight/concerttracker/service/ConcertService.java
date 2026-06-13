package com.pluralsight.concerttracker.service;

import com.pluralsight.concerttracker.data.ArtistRepository;
import com.pluralsight.concerttracker.data.ConcertRepository;
import com.pluralsight.concerttracker.data.PromoterRepository;
import com.pluralsight.concerttracker.data.VenueRepository;
import com.pluralsight.concerttracker.entites.Artist;
import com.pluralsight.concerttracker.entites.Concert;
import com.pluralsight.concerttracker.entites.Promoter;
import com.pluralsight.concerttracker.entites.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    //Seed Data
    public void seedIfEmpty(){
    if (cr.count() > 0){
        return;
    }   //Venues
        Venue citizensBankPark = vr.save(new Venue("Citizens Bank Park", "Philadelphia", 42901));
        Venue lincolnFinancialField = vr.save(new Venue("Lincoln Financial Field", "Philadelphia", 67594));
        Venue dellMusicCenter = vr.save(new Venue("Dell Music Center", "Philadelphia", 6002));
        Venue franklinMusicHall = vr.save(new Venue("Franklin Music Hall", "Philadelphia", 2500));
        Venue ardmoreMusicHall = vr.save(new Venue("Ardmore Music Hall", "Ardmore", 600));
        Venue grandOperaHouse = vr.save(new Venue("Grand Opera House", "Wilmington", 1140));
        Venue whiteEagleHall = vr.save(new Venue("White Eagle Hall", "Jersey City", 800));
        //Promoters
        Promoter liveNation = pr.save(new Promoter("Live Nation"));
        Promoter ticketMaster = pr.save(new Promoter("Ticket Master"));
        Promoter tickPick = pr.save(new Promoter("Tick Pick"));
        Promoter aegPresents = pr.save(new Promoter("AEG Presents"));
        Promoter imp = pr.save(new Promoter("I.M.P"));
        Promoter boweryPresents = pr.save(new Promoter("Bowery Presents"));
        Promoter seatGeek = pr.save(new Promoter("Seat Geek"));
        //Artists
        Artist summerWalker = ar.save(new Artist("Summer Walker", "Soul"));
        Artist taylorSwift = ar.save(new Artist("Taylor Swift", "Pop"));
        Artist theWeekend = ar.save(new Artist("The Weekend", "Pop"));
        Artist sza = ar.save(new Artist("Sza", "Neo Soul"));
        Artist travisScott = ar.save(new Artist("Travis Scott", "Rap"));
        Artist iceSpice = ar.save(new Artist("Ice Spice", "Rap"));
        Artist tameImpala = ar.save(new Artist("Tame Impala", "Indie-Rock"));
        //Concerts
        cr.save(new Concert(2023,10000,200.00,lincolnFinancialField,taylorSwift,ticketMaster));
        cr.save(new Concert(2022,13000,130.00,citizensBankPark,summerWalker,liveNation));
        cr.save(new Concert(2017,8900,87.00,dellMusicCenter,theWeekend,tickPick));
        cr.save(new Concert(2009,7300,100.00,franklinMusicHall,sza,aegPresents));
        cr.save(new Concert(2023,5000,135.00,ardmoreMusicHall,travisScott,imp));
        cr.save(new Concert(2025,6000,130.00,grandOperaHouse,iceSpice,boweryPresents));
        cr.save(new Concert(2025,1600,255.00,whiteEagleHall,tameImpala,seatGeek));



    }
    //List ALL Concerts (Artist and Venue)
    public void allConcerts(){
        System.out.println(" You have " + cr.count() + "Concerts");
        for (Concert c : cr.findAll()) {
            System.out.println(c.getConcertArtist().getArtistName() + "|" + c.getConcertVenue().getVenueName() + "(" + c.getTicketPrice() + ")" );

        }
    }
    public String getStatus(){
    return "Concerts are Loading...";
    }

}
