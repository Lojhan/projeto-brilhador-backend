package com.clientRelationship.clientRelationshipProject.controllers;
import com.clientRelationship.clientRelationshipProject.models.base.Ticket;
import com.clientRelationship.clientRelationshipProject.models.dto.TicketInfo;
import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;
import com.clientRelationship.clientRelationshipProject.services.CreateTicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Create Ticket")
@RestController @RequestMapping(path = "create-ticket")
public class CreateTicketController {

    @Autowired
    CreateTicketService service;

    @PostMapping(path = "")
    public ResponseEntity<Ticket> create(
        @RequestAttribute("user") UserResponse user,
        TicketInfo info
    ) {
        try {
            Ticket ticket = service.createTicketForUser(user, info);
            return ResponseEntity.status(200).body(ticket);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
