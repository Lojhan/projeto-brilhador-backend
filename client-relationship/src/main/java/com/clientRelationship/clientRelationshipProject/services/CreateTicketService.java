package com.clientRelationship.clientRelationshipProject.services;

import java.util.UUID;

import com.clientRelationship.clientRelationshipProject.configuration.messaging.QueueSender;
import com.clientRelationship.clientRelationshipProject.models.base.Ticket;
import com.clientRelationship.clientRelationshipProject.models.dto.TicketInfo;
import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;
import com.clientRelationship.clientRelationshipProject.models.dto.UserTicketDTO;
import com.clientRelationship.clientRelationshipProject.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    QueueSender queueSender;

    public Ticket createTicketForUser(
        UserResponse user,
        TicketInfo ticketInfo
    ) {
        Ticket ticket = ticketInfo.toCompleteTicket(user.getId(), new UUID(0, 0));
        this.queueSender.sendUserTicketMessage(new UserTicketDTO(user, ticketInfo));
        return ticketRepository.save(ticket);
    }    
}
