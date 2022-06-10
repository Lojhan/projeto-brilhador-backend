package com.supplyChain.supplyChainProject.models;

import com.supplyChain.supplyChainProject.models.enums.EStatus;

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

    public EmployeeTask toEmployeeTask() {
        EmployeeTask task = new EmployeeTask();
        task.setName(this.ticket.getTitle());
        task.setDescription(this.ticket.getDescription());
        task.setDaysToFinish(5);
        task.setStatus(EStatus.IN_PROGRESS);
        return task;
    }
}
