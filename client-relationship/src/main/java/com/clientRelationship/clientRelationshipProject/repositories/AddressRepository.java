package com.clientRelationship.clientRelationshipProject.repositories;

import org.springframework.stereotype.Repository;

import com.clientRelationship.clientRelationshipProject.models.base.Address;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
        @Query("select a from Address as a where a.userId = ?1")
        public Optional<Address> findByUserId(UUID id);
}
    
