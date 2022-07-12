package com.example.kms.Service;

import com.example.kms.model.CryptoKey;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


import javax.crypto.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

@Service
public class CreatingKey {
    KeyGenerator keyGenerator;

    public CryptoKey generateKey(String keyName , String aliases , String status){



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
            CryptoKey cr = new CryptoKey(keyName,aliases,new Date(),status,secretKey);
            return cr;

        }
    }


}




