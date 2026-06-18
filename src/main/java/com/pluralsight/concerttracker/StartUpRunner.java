package com.pluralsight.concerttracker;

import com.pluralsight.concerttracker.models.Artist;
import com.pluralsight.concerttracker.models.Promoter;
import com.pluralsight.concerttracker.models.Venue;
import com.pluralsight.concerttracker.service.ConcertService;
import com.pluralsight.concerttracker.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class StartUpRunner implements CommandLineRunner {

    private final ConcertService cs;

@Autowired //inject ConcertService inside the class so i can use
    public StartUpRunner(ConcertService cs) {
        this.cs = cs;
    }

    @Override
    public void run(String... args) throws Exception {
    cs.seedIfEmpty();
        Scanner userScanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            mainMenu();
            try {
                switch(userScanner.nextInt()){
                    case 1 -> concertScreen(userScanner);
                    case 2 -> searchConcertScreen(userScanner);
                    case 3 -> artistScreen(userScanner);
                    case 4 -> venueScreen(userScanner);
                    case 5 -> promoterScreen(userScanner);
                    case 6 -> reportScreen(userScanner);
                    case 0 -> running = false;
                    default -> System.out.println("Unknown option");
                }
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void mainMenu(){
        System.out.println("""
                        === Concert Menu ===
                        1) Concerts
                        2) Search Concerts
                        3) Artists
                        4) Venues
                        5) Promoters
                        6) Reports
                        0) Quit(exit)
                        =====================
                """);
        System.out.println("Choose:");
    }
    private void concertScreen(Scanner scanner){
        boolean screenRunning = false;
        while (!screenRunning){
            System.out.println("""
                        === Concert Screen ===
                        1) List All Concerts
                        2) View by ID
                        3) Add Concert
                        4) Update ticket price
                        5) Update ticket sold
                        6) Delete Concert
                        0) Back <-
                        =====================
                """);
            int userChoice = scanner.nextInt();
            switch (userChoice){
                case 1 -> {
                    cs.listAllConcerts();
                }
                case 2 -> {
                    System.out.println("Enter Concert ID to view");
                    long inputId = scanner.nextLong();
                    cs.byId(inputId);
                }
                 case 3 -> {
                        System.out.println("Enter year: ");
                        int year = scanner.nextInt();
                        System.out.println("Enter how many tickets: ");
                        scanner.nextLine();
                        int ticketSold = scanner.nextInt();
                        System.out.println("Enter ticket price: ");
                        double ticketPrice = scanner.nextDouble();
                        System.out.println("Enter Venue Name: ");
                        String venueName = scanner.nextLine();
                        System.out.println("Enter Venue city: ");
                        String city = scanner.nextLine();
                        System.out.println("Enter Capacity: ");
                        int capacity = scanner.nextInt();
                        System.out.println("Enter Artist: ");
                        scanner.nextLine();
                        String artistName = scanner.nextLine();
                        System.out.println("Enter Genre: ");
                        String genre = scanner.nextLine();
                        System.out.println("Enter Promoter: ");
                        String promoterName = scanner.nextLine();
                        cs.addConcert(year,ticketSold,ticketPrice,new Venue(venueName,city,capacity),new Artist(artistName,genre),new Promoter(promoterName));
                        System.out.println("Added!");
                    }

                case 4 -> {
                    System.out.print("Concert id: ");
                    long id = scanner.nextLong();
                    System.out.print("New ticket price: ");
                    double newPrice = scanner.nextDouble();
                    cs.updateTicketPrice(id,newPrice);
                    System.out.println("Updated!");

                }
                case 5 -> {
                    System.out.print("Concert id: ");
                    long id = scanner.nextLong();
                    System.out.print("New tickets sold: ");
                    int ticketsSold = scanner.nextInt();
                    cs.updateTicketSold(id, ticketsSold);
                    System.out.println("Updated!");

                }
                case 6 -> {
                    System.out.print("Concert id: ");
                    long id = scanner.nextLong();
                    cs.deleteConcert(id);
                }
                case 0 -> {
                    screenRunning = true;
                }
            }
        }
    }
    private void searchConcertScreen(Scanner scanner){
        boolean screenRunning = false;
        while (!screenRunning){
            System.out.println("""
                        === Custom Search Screen===
                        1) By Year
                        2) By Artist
                        3) By Venue
                        4) By City
                        5) By Maximum Price
                        6) By Price Range
                        7) Advanced(MaxPrice & Year)
                        0) Back <-
                        ===========================
                """);
            int userChoice = scanner.nextInt();
            switch (userChoice){}
        }
    }
    private void artistScreen(Scanner scanner){
        boolean screenRunning = false;
        while (!screenRunning){
            System.out.println("""
                        === Artists Screen ===
                        1) List All Artists
                        2) BY Genre
                        3) By Name
                        4) Update Genre
                        5) Add Artist
                        6) Delete Artist
                        0) Back <-
                        =====================
                """);
            int userChoice = scanner.nextInt();
            switch (userChoice){}
        }
    }
    private void venueScreen(Scanner scanner){
        boolean screenRunning = false;
        while (!screenRunning){
            System.out.println("""
                        === Venues Screen ===
                        1) List All Venues
                        2) By City
                        3) BY Name
                        4) By Minimum Capacity
                        5) Update Capacity
                        6) Add Venue
                        7) Delete Venue
                        0) Back <-
                        =====================
                """);
            int userChoice = scanner.nextInt();
            switch (userChoice){}
        }
    }
    private void promoterScreen(Scanner scanner){
        boolean screenRunning = false;
        while (!screenRunning){
            System.out.println("""
                        === Promoters Screen ===
                        1) List All Promoters
                        2) By Name
                        3) Add Promoter
                        6) Delete Promoter
                        0) Back <-
                        =====================
                """);
            int userChoice = scanner.nextInt();
            switch (userChoice){}
        }
    }
    private void reportScreen(Scanner scanner){
        boolean screenRunning = false;
        while (!screenRunning){
            System.out.println("""
                        === Reports Screen ===
                        1) Revenue per Venue
                        2) Busiest Venue + Artist
                        3) Average Ticket Price
                        4) Capacity Report
                        0) Back <-
                        =====================
                """);
            int userChoice = scanner.nextInt();
            switch (userChoice){}
        }
    }
}
