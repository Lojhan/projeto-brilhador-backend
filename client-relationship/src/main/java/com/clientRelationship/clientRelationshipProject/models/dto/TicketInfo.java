package com.clientRelationship.clientRelationshipProject.models.dto;

import java.io.Serializable;
import java.util.UUID;

import com.clientRelationship.clientRelationshipProject.models.base.Ticket;
import com.clientRelationship.clientRelationshipProject.models.base.TicketPriority;
import com.clientRelationship.clientRelationshipProject.models.base.TicketStatus;
public class TicketInfo implements Serializable {

    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;

    public TicketInfo() {
        super();
    }
    
    public TicketInfo(String title, String description, TicketStatus status, TicketPriority priority) {
        super();
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Ticket toCompleteTicket(UUID userId, UUID operatorId) {
        return new Ticket(
            title,
            description,
            status,
            priority,
            userId,
            operatorId
        );
    }

    public String toJson() {
        // creates a json string from the object data
        String json = "{";
        json += "\"title\":\"" + title + "\",";
        json += "\"description\":\"" + description + "\",";
        json += "\"status\":\"" + status + "\",";
        json += "\"priority\":\"" + priority + "\"";
        json += "}";
        return json;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public String toJSON() {
        String json = "{";
        json += "\"title\":\"" + title + "\",";
        json += "\"description\":\"" + description + "\",";
        json += "\"status\":\"" + status + "\",";
        json += "\"priority\":\"" + priority + "\"";
        json += "}";
        return json;
    }
}
