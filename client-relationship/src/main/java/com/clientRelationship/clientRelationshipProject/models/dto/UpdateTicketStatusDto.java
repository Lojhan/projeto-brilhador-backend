package com.clientRelationship.clientRelationshipProject.models.dto;

import com.clientRelationship.clientRelationshipProject.models.base.TicketStatus;

public class UpdateTicketStatusDto {
    private TicketStatus status;

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
