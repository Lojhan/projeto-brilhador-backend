package com.clientRelationship.clientRelationshipProject.models.dto;

import com.clientRelationship.clientRelationshipProject.models.base.Ticket;

public class UserAndTicketDto {
    public UserResponse user;
    public Ticket ticket;

    public UserAndTicketDto(UserResponse user, Ticket ticket) {
        this.user = user;
        this.ticket = ticket;
    }
}
