package com.supplyChain.supplyChainProject.models;

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
        task.setTask(this.ticket.getTitle());
        task.setDescription(this.ticket.getDescription());
        task.setDependOnThirdParty("");
        task.setStatus(false);
        return task;
    }
}
