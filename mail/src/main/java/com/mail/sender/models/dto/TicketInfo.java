package com.mail.sender.models.dto;

import java.io.Serializable;

import com.mail.sender.models.base.TicketPriority;
import com.mail.sender.models.base.TicketStatus;

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
}
