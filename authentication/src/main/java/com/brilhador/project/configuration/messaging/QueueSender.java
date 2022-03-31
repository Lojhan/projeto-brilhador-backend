package com.brilhador.project.configuration.messaging;

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

    public void sendMailMessage(String order) {
        rabbitTemplate.convertAndSend(this.mailQueue.getName(), order);
    }
}