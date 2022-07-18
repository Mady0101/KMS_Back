package com.example.kms.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kms.model.CryptoKey;

@Repository
public interface CryptoKeyRepository extends JpaRepository<CryptoKey, UUID> {

    @Query(value = "SELECT * FROM cryptokey WHERE customer_id=:id", nativeQuery = true)
    public List<CryptoKey> getCryptokeyByCustomerID(@Param("id") UUID id) ;

}
