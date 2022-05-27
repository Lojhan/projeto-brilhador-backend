package com.supplyChain.supplyChainProject.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.supplyChain.supplyChainProject.models.Movement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
    
    @Query("select m from Movements as m")
    public List<Movement> findAll();

    @Query("select m from Movements as m where m.id = ?1")
    public Optional<Movement[]> findById(UUID userId);
}
