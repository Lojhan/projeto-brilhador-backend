package com.clientRelationship.clientRelationshipProject.services;

import java.util.UUID;

import com.clientRelationship.clientRelationshipProject.models.base.Ticket;
import com.clientRelationship.clientRelationshipProject.models.base.TicketStatus;
import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;
import com.clientRelationship.clientRelationshipProject.models.exceptions.NotFound;
import com.clientRelationship.clientRelationshipProject.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeTicketStatusService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired 
    private CreateNotificationService notificationService;

    @Autowired
    private GetUserService userService;

    public Ticket changeTicketStatus(UUID ticketId, TicketStatus status) throws NotFound {
        Ticket ticket = ticketRepository
            .findById(ticketId)
            .orElseThrow(() -> new NotFound(String.format("ticket with id %s not found", ticketId.toString())));

        UserResponse user = userService.getUser(ticket.getUserId().toString());
        String message = String.format("Ticket %s status changed to %s", ticket.getId().toString(), status.toString());
        notificationService.createNotification(message, user.getPhone());
        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }
}
