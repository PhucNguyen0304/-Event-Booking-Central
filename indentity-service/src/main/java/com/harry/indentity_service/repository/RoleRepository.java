package com.harry.indentity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harry.indentity_service.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
