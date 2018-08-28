package com.pme.decsoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pme.decsoft.app.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
