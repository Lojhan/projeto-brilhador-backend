package com.clientRelationship.clientRelationshipProject.configuration.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    
    @Value("${queue.name.userTicket}")
    private String message;

    @Value("${ticket-mail.queue.name}")
    private String ticketMailQueue;

    @Bean(name = "userTicketsQueue")
    public Queue userTicketsQueue() {
        return new Queue(message, true);
    }

    @Bean(name = "ticketMailQueue")
    public Queue ticketMailQueue() {
        return new Queue(ticketMailQueue, true);
    }

    // @Bean(name = "anotherQueue")
    // public Queue anotherQueue() {
    //     return new Queue(message, true);
    // }

}