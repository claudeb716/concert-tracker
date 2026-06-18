package com.pluralsight.concerttracker.service;

import com.pluralsight.concerttracker.data.ArtistRepository;
import com.pluralsight.concerttracker.data.ConcertRepository;
import com.pluralsight.concerttracker.data.PromoterRepository;
import com.pluralsight.concerttracker.data.VenueRepository;
import com.pluralsight.concerttracker.models.Artist;
import com.pluralsight.concerttracker.models.Concert;
import com.pluralsight.concerttracker.models.Promoter;
import com.pluralsight.concerttracker.models.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertService {
    //communicate to the repos
    private final ConcertRepository concertRepository;
    private final PromoterRepository pr;
    private final ArtistRepository ar;
    private final VenueRepository venueRepository;
    //Constructor Injection
@Autowired
    public ConcertService(ConcertRepository cr, PromoterRepository pr, ArtistRepository ar, VenueRepository vr) {
        this.concertRepository = cr;
        this.pr = pr;
        this.ar = ar;
        this.venueRepository = vr;
    }
    //Seed Data
    public void seedIfEmpty(){
    if (concertRepository.count() > 0){
        return;
    }   //Venues
        Venue citizensBankPark = venueRepository.save(new Venue("Citizens Bank Park", "Philadelphia", 42901));
        Venue lincolnFinancialField = venueRepository.save(new Venue("Lincoln Financial Field", "Philadelphia", 67594));
        Venue dellMusicCenter = venueRepository.save(new Venue("Dell Music Center", "Philadelphia", 6002));
        Venue franklinMusicHall = venueRepository.save(new Venue("Franklin Music Hall", "Philadelphia", 2500));
        Venue ardmoreMusicHall = venueRepository.save(new Venue("Ardmore Music Hall", "Ardmore", 600));
        Venue grandOperaHouse = venueRepository.save(new Venue("Grand Opera House", "Wilmington", 1140));
        Venue whiteEagleHall = venueRepository.save(new Venue("White Eagle Hall", "Jersey City", 800));
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
        concertRepository.save(new Concert(2023,10000,200.00,lincolnFinancialField,taylorSwift,ticketMaster));
        concertRepository.save(new Concert(2022,13000,130.00,citizensBankPark,summerWalker,liveNation));
        concertRepository.save(new Concert(2017,8900,87.00,dellMusicCenter,theWeekend,tickPick));
        concertRepository.save(new Concert(2009,7300,100.00,franklinMusicHall,sza,aegPresents));
        concertRepository.save(new Concert(2023,5000,135.00,ardmoreMusicHall,travisScott,imp));
        concertRepository.save(new Concert(2025,6000,130.00,grandOperaHouse,iceSpice,boweryPresents));
        concertRepository.save(new Concert(2025,1600,255.00,whiteEagleHall,tameImpala,seatGeek));



    }
    //List ALL Concerts (Artist and Venue)
    public void listAllConcerts(){
        System.out.println(" You have " + concertRepository.count() + "Concerts");
        for (Concert c : concertRepository.findAll()) {
            System.out.println(c.getConcertArtist().getArtistName() + "|" + c.getConcertVenue().getVenueName() + "(" + c.getConcertPromoter() + ")" );

        }
    }
    //Manage Concerts
    public Concert byId(long concertId){

        return concertRepository.findById(concertId).orElseThrow(() -> new NotFoundException(" No Concert Found with id" + concertId));
    }
    public void addConcert(int year, int sold, double price, Venue v, Artist a, Promoter p){

        concertRepository.save(new Concert(year, sold, price, v, a, p));
    }
    public void updateTicketPrice(Long id, double price){
    Concert concert = byId(id);
    concert.setTicketPrice(price);
        concertRepository.save(concert);
        System.out.println("updated");
    }
    public void updateTicketSold(long id, int sold){
        Concert update = byId(id);
        update.setTicketsSold(sold);
        concertRepository.save(update);
        System.out.println("updated");
    }
    public void deleteConcert(Long id){
    if (!concertRepository.existsById(id)){
        throw new NotFoundException("No Concert with ID " + id);
    }
    concertRepository.deleteById(id);
    }
    //Manage venues
    public Venue addVenue(String name,String city,int capacity){
    return venueRepository.save(new Venue(name,city,capacity));
    }

    public void listVenue(long id){
    concertRepository.findByConcertVenue_VenueName();
        System.out.println(" You have " + concertRepository.count() + "Concerts");
        for (Concert venue : concertRepository.findAll()) {
            System.out.println(venue.getId() + venue.getConcertVenue().getVenueName() + "|" + venue.getConcertYear() + "|" + venue.getConcertArtist());

        }
    }
    public List<Concert> updateCapacity(String name){
    return concertRepository.findByConcertVenue_VenueName(name);

    }
    public void deleteVenue(){}
    public Venue byVenueName(){}
    public Venue byMinCapacity(){}

    //Manage artists
    //Manage promoters
    public String getStatus(){
    return "Concerts are Loading...";
    }

}
