package com.brilhador.authentication.configuration.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void mailQueue(@Payload String fileBody) {
        System.out.println("Message " + fileBody);
    }

    // @RabbitListener(queues = {"another-queue"})
    // public void receive(@Payload String fileBody) {
    //     System.out.println("Message " + fileBody);
    // }

}