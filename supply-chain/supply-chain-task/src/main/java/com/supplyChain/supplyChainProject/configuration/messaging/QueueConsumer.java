package com.supplyChain.supplyChainProject.configuration.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplyChain.supplyChainProject.models.UserTicketDTO;
import com.supplyChain.supplyChainProject.repositories.EmployeeTaskRepository;

@Component
public class QueueConsumer {

    @Autowired
    EmployeeTaskRepository repository;

    @RabbitListener(queues = {"${queue.name.userTicketEmplyeeTask}"})
    public void mailQueue(@Payload String params) {
        System.out.println("Message " + params);
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserTicketDTO map = mapper.readValue(params, UserTicketDTO.class);

            System.out.println("[QueueConsumer] - Creating new EmployeeTask");
            this.repository.save(map.toEmployeeTask());
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    // @RabbitListener(queues = {"another-queue"})
    // public void receive(@Payload String fileBody) {
    //     System.out.println("Message " + fileBody);
    // }

}