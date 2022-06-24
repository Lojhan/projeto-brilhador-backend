package com.clientRelationship.clientRelationshipProject.configuration.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.clientRelationship.clientRelationshipProject.models.dto.UserAddressDTO;
import com.clientRelationship.clientRelationshipProject.services.SaveUserAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class QueueConsumer {

    @Autowired
    private SaveUserAddressService saveUserAddressService;
    
    @RabbitListener(queues = {"${queue.name}"})
    public void mailQueue(@Payload String fileBody) {
        System.out.println("Message " + fileBody);
    }

    // @RabbitListener(queues = {"another-queue"})
    // public void receive(@Payload String fileBody) {
    //     System.out.println("Message " + fileBody);
    // }


    @RabbitListener(queues = {"${queue.name.userAddr}"})
    public void userAddressQueueConsume(@Payload String params) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserAddressDTO map = mapper.readValue(params, UserAddressDTO.class);
            
            this.saveUserAddressService.save(map);

        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}