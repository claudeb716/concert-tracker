package com.pluralsight.concerttracker;

import com.pluralsight.concerttracker.service.ConcertService;
import com.pluralsight.concerttracker.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class StartUpRunner implements CommandLineRunner {

    private final ConcertService cs;

@Autowired
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
                    case 1 -> cs.allConcerts();
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
                        0) Quit
                        =====================
                """);
        System.out.println("Choose:");
    }
}
