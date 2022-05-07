package com.brilhador.authentication.configuration.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Value("${queue.name}")
    private String message;

    @Bean(name = "mailQueue")
    public Queue mailQueue() {
        return new Queue(message, true);
    }

    // @Bean(name = "anotherQueue")
    // public Queue anotherQueue() {
    //     return new Queue(message, true);
    // }

}