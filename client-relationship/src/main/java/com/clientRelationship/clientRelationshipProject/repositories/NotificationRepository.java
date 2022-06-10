package com.clientRelationship.clientRelationshipProject.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clientRelationship.clientRelationshipProject.models.base.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>   {
    
}
