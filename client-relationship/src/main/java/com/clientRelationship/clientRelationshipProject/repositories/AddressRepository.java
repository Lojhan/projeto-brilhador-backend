package com.clientRelationship.clientRelationshipProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientRelationship.clientRelationshipProject.models.base.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>  {
    
}
