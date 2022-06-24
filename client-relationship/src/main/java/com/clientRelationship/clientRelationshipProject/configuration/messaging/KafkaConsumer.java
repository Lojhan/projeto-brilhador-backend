package com.clientRelationship.clientRelationshipProject.configuration.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.clientRelationship.clientRelationshipProject.models.dto.UserAddressDTO;
import com.clientRelationship.clientRelationshipProject.services.SaveUserAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
  
@Component
public class KafkaConsumer {
  
    @Autowired
    private SaveUserAddressService saveUserAddressService;
    
    @KafkaListener(topics = "deconto", groupId = "1001")
    public void consume(String message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserAddressDTO map = mapper.readValue(message, UserAddressDTO.class);
            
            this.saveUserAddressService.save(map);

        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}