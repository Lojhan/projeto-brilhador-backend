package com.clientRelationship.clientRelationshipProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientRelationship.clientRelationshipProject.models.base.Notification;
import com.clientRelationship.clientRelationshipProject.repositories.NotificationRepository;

@Service
public class CreateNotificationService {
    
    @Autowired private NotificationRepository notificationRepository;
    
    public Notification createNotification(String message, String phone) {
        return notificationRepository.save(new Notification(message, phone));
    }
}
