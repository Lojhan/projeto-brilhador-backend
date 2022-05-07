package com.mail.sender.configuration.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.sender.models.dto.TicketInfo;
import com.mail.sender.models.dto.UserTicketDTO;
import com.mail.sender.service.MailService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class QueueConsumer {
    
    @Autowired
    private MailService mailService;

    @RabbitListener(queues = {"${queue.name.userTicket}"})
    public void userTicketMailQueueConsume(@Payload String params) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserTicketDTO map = mapper.readValue(params, UserTicketDTO.class);
            TicketInfo ticket = map.ticket;

            String to = map.user.getEmail();

            String subject = String.format("[%s PRIORITY TICKET] Ticket Criado!", ticket.getPriority());

            String body = String.format("Olá %s,\n\n" +
                    "Seu ticket foi criado com sucesso!\n\n" +
                    "Ticket Priority: %s\n" +
                    "Ticket Description: %s\n\n" +
                    "Atenciosamente,\n" +
                    "Equipe Ticket Service",
                    map.user.getName(),
                    ticket.getPriority(),
                    ticket.getDescription());

            System.out.println("[QueueConsumer] - Sending email to: " + to);
            this.mailService.sendSimpleMessage(to, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}