package com.clientRelationship.clientRelationshipProject.configuration.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    
    @Value("${queue.name.userTicket}")
    private String message;

    @Value("${queue.name.userTicketEmplyeeTask}")
    private String userTicketEmplyeeTask;

    @Value("${queue.name.userAddr}")
    private String userAddr;

    @Bean(name = "userTicketEmployeeTaskQueue")
    public Queue userTicketEmployeeTaskQueue() {
        return new Queue(userTicketEmplyeeTask, true);
    }

    @Bean(name = "userTicketsQueue")
    public Queue userTicketsQueue() {
        return new Queue(message, true);
    }

    @Bean(name = "userAddrQueue")
    public Queue userAddrQueue() {
        return new Queue(userAddr, true);
    }

    

    // @Bean(name = "anotherQueue")
    // public Queue anotherQueue() {
    //     return new Queue(message, true);
    // }

}