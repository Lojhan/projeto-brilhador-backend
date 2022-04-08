package com.clientRelationship.clientRelationshipProject.configuration.messaging;

import com.clientRelationship.clientRelationshipProject.models.dto.UserAndTicketDto;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("mailQueue")
    @Autowired()
    private Queue mailQueue;

    @Qualifier("ticketMailQueue")
    @Autowired()
    private Queue ticketMailQueue;

    public void sendMailMessage(String order) {
        rabbitTemplate.convertAndSend(this.mailQueue.getName(), order);
    }

    public void sendTicketMailMessage(UserAndTicketDto dto) {
        rabbitTemplate.convertAndSend(this.ticketMailQueue.getName(), dto);
    }
}