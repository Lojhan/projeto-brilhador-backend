package com.clientRelationship.clientRelationshipProject.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import com.clientRelationship.clientRelationshipProject.models.base.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select t from Ticket as t where t.id = ?1")
    public Optional<Ticket> findById(UUID id);

    @Query("select t from Ticket as t where t.userId = ?1")
    public Optional<Ticket[]> findByUserId(UUID userId);
}
    
