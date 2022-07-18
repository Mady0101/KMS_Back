package com.example.kms.SpringJwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kms.SpringJwt.models.ERole;
import com.example.kms.SpringJwt.models.Role;



@Repository

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}