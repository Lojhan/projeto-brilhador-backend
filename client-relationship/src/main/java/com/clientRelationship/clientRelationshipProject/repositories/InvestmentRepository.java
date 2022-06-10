package com.clientRelationship.clientRelationshipProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientRelationship.clientRelationshipProject.models.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> { }
