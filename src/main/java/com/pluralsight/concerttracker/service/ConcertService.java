package com.pluralsight.concerttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertService {
@Autowired
    public ConcertService() {
    }
    public String getStatus(){
    return "Concerts are Loading...";
    }
}
