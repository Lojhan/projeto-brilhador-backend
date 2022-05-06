package com.mail.sender.configuration.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("userTicketsQueue")
    @Autowired()
    private Queue userTicketsQueue;

    public void sendUserTicketMessage(String order) {
        rabbitTemplate.convertAndSend(this.userTicketsQueue.getName(), order);
    }
}