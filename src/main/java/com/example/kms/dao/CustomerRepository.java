package com.example.kms.dao;


import com.example.kms.model.Customer;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID>{


}


// This will be AUTO IMPLEMENTED by Spring into a Bean called CustomerRepository
// CRUD refers Create, Read, Update, Delete

