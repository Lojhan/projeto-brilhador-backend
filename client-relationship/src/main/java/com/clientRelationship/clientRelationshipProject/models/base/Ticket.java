package com.clientRelationship.clientRelationshipProject.models.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tickets")
public class Ticket {
    
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;
    private UUID userId;
    private UUID operatorId;

    public Ticket() {
    }

    public Ticket(
        UUID id,
        String title, 
        String description, 
        TicketStatus status, 
        TicketPriority priority, 
        UUID userId,
        UUID operatorId
        ) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.status = status;
            this.priority = priority;
            this.userId = userId;
            this.operatorId = operatorId;
    }

    public Ticket(
        String title, 
        String description, 
        TicketStatus status, 
        TicketPriority priority, 
        UUID userId,
        UUID operatorId
        ) {
            this.title = title;
            this.description = description;
            this.status = status;
            this.priority = priority;
            this.userId = userId;
            this.operatorId = operatorId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(UUID operatorId) {
        this.operatorId = operatorId;
    }
}