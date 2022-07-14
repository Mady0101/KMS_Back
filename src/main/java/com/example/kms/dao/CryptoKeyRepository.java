package com.example.kms.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kms.model.CryptoKey;

@Repository
public interface CryptoKeyRepository extends JpaRepository<CryptoKey, UUID> {

}
