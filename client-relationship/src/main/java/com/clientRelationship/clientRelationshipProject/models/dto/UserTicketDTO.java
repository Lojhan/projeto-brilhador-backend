package com.clientRelationship.clientRelationshipProject.models.dto;

import java.io.Serializable;

public class UserTicketDTO implements Serializable {
    public UserResponse user;
    public TicketInfo ticket;

    public UserTicketDTO() {
        super();
    }

    public UserTicketDTO(UserResponse user, TicketInfo ticket) {
        super();
        this.user = user;
        this.ticket = ticket;
    }

    public String toJSON() {
        // creates a json string from the object data
        String json = "{";
        json += "\"user\":" + user.toJSON() + ",";
        json += "\"ticket\":" + ticket.toJSON();
        json += "}";
        return json;
    }
}
