package com.example.kms.model;

import javax.crypto.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class Generatingkey {

    KeyGenerator keyGenerator;

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


    }
}
