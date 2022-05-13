package com.mail.sender.models.dto;

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
}
