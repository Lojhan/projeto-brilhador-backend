package com.clientRelationship.clientRelationshipProject.controllers;
import java.util.UUID;

import com.clientRelationship.clientRelationshipProject.models.base.Ticket;
import com.clientRelationship.clientRelationshipProject.models.dto.TicketInfo;
import com.clientRelationship.clientRelationshipProject.models.dto.UpdateTicketStatusDto;
import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;
import com.clientRelationship.clientRelationshipProject.models.exceptions.NotFound;
import com.clientRelationship.clientRelationshipProject.services.ChangeTicketStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Change ticket status")
@RestController @RequestMapping(path = "change-ticket-status")
public class ChangeTicketStatusController {

    @Autowired
    ChangeTicketStatusService service;

    @PutMapping(path = "/{ticketId}")
    public ResponseEntity<Ticket> create(
        @RequestAttribute("user") UserResponse user,
        @PathVariable UUID ticketId,
        UpdateTicketStatusDto ticketInfo
    ) {
        try {
            return ResponseEntity.ok(service.changeTicketStatus(ticketId, ticketInfo.getStatus()));
        } catch (NotFound e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
