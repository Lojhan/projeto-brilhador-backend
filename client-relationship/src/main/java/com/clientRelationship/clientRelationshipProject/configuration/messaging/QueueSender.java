package com.clientRelationship.clientRelationshipProject.configuration.messaging;

import com.clientRelationship.clientRelationshipProject.models.dto.UserAndTicketDto;
import com.clientRelationship.clientRelationshipProject.models.dto.UserTicketDTO;

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

    @Qualifier("ticketMailQueue")
    @Autowired()
    private Queue ticketMailQueue;

    public void sendUserTicketMessage(UserTicketDTO userTicketDTO) {
        rabbitTemplate.convertAndSend(this.userTicketsQueue.getName(), userTicketDTO.toJSON());
    }

    public void sendTicketMailMessage(UserAndTicketDto dto) {
        rabbitTemplate.convertAndSend(this.ticketMailQueue.getName(), dto);
    }
}