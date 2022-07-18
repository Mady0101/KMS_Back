package com.example.kms.dao;


import com.example.kms.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, UUID>{
    @Query(value = "SELECT * FROM customer Cr WHERE Cr.customer_user_name=:username", nativeQuery = true)

    Optional<Customer> findByUsername(@Param("username") String username);


    Boolean existsByCustomerUserName(String username);

    Boolean existsByCustomerEmail(String email);




}





// This will be AUTO IMPLEMENTED by Spring into a Bean called CustomerRepository
// CRUD refers Create, Read, Update, Delete

