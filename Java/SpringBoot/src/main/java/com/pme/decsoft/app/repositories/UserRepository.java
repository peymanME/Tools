package com.pme.decsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pme.decsoft.app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}