package com.clientRelationship.clientRelationshipProject.services;

import java.util.UUID;

import com.clientRelationship.clientRelationshipProject.models.base.Ticket;
import com.clientRelationship.clientRelationshipProject.models.exceptions.NotFound;
import com.clientRelationship.clientRelationshipProject.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllTicketsForUserService {

    @Autowired
    TicketRepository ticketRepository;

    public Ticket[] getAllForUser(UUID string) throws NotFound {
        return ticketRepository
            .findByUserId(string)
            .orElseThrow(() -> new NotFound("Ticket"));
    }
    
}
