package com.example.kms.Service;

import com.example.kms.model.CryptoKey;
import com.example.kms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


import javax.crypto.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;
import com.example.kms.dao.CryptoKeyRepository ;
@Service
public class CreatingKey {


    KeyGenerator keyGenerator;
    @Autowired
    CryptoKeyRepository cryptoKeyRepository ;

    public CryptoKey generateKey(String keyName , String aliases , String status, UUID id){



        {
            try {
                keyGenerator = KeyGenerator.getInstance("AES");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

            SecureRandom secureRandom = new SecureRandom();
            int keyBitSize = 256;

            keyGenerator.init(keyBitSize, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            CryptoKey cr = new CryptoKey(keyName,aliases,new Date(),status,secretKey,new Customer(id));
            cryptoKeyRepository.save(cr) ;
            return cr;

        }
    }




}




