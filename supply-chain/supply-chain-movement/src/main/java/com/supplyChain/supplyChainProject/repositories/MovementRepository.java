package com.supplyChain.supplyChainProject.repositories;

import com.supplyChain.supplyChainProject.models.Movement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {


}
