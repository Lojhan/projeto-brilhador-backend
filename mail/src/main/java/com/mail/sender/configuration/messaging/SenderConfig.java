package com.mail.sender.configuration.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Value("${queue.name.userTicket}")
    private String message;

    @Bean(name = "userTicketsQueue")
    public Queue userTicketsQueue() {
        return new Queue(message, true);
    }
}