package com.example.kms.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


import javax.crypto.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
public class CreatingKey {



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




