package com.brilhador.authentication.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import com.brilhador.authentication.models.base.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User as u where u.email = ?1")
    public Optional<User> findByEmail(String email);

    @Query("select u from User as u where u.id = ?1")
    public Optional<User> findById(UUID id);
}
    
