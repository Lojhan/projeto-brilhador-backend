package com.clientRelationship.clientRelationshipProject.services;

import java.util.UUID;

import com.clientRelationship.clientRelationshipProject.models.base.Ticket;
import com.clientRelationship.clientRelationshipProject.models.base.TicketStatus;
import com.clientRelationship.clientRelationshipProject.models.exceptions.NotFound;
import com.clientRelationship.clientRelationshipProject.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeTicketStatusService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket changeTicketStatus(UUID ticketId, TicketStatus status) throws NotFound {
        Ticket ticket = ticketRepository
            .findById(ticketId)
            .orElseThrow(() -> new NotFound(String.format("ticket with id %s not found", ticketId.toString())));
        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }
}
