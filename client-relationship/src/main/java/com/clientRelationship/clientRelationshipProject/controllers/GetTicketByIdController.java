package com.clientRelationship.clientRelationshipProject.controllers;

import java.util.UUID;

import com.clientRelationship.clientRelationshipProject.models.base.Ticket;
import com.clientRelationship.clientRelationshipProject.models.exceptions.NotFound;
import com.clientRelationship.clientRelationshipProject.services.GetTicketByIdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Get Ticket By Id")
@RestController @RequestMapping(path = "ticket")
public class GetTicketByIdController {
    
    @Autowired
    GetTicketByIdService service;

    @GetMapping(path = "/{ticketId}")
    public ResponseEntity<Ticket> get(
        @PathVariable UUID ticketId
    ) {
        try {
            Ticket ticket = service.get(ticketId);
            return ResponseEntity.status(200).body(ticket);
        } catch (NotFound e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
