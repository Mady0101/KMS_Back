 package com.example.kms.model;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;


@Entity
public class Key {

        @Id
        private UUID KeyId;
        private String KeyName;
        private String Aliases;
        private Date CreationDate;
        private String Status;


        public UUID getKeyId () {
            return KeyId;
        }

        public void setKeyId (UUID keyId){
            KeyId = keyId;
        }

        public String getKeyName () {
            return KeyName;
        }

        public void setKeyName (String keyName){
            KeyName = keyName;
        }

        public void GenerateKey () {
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


        public String getAliases () {
            return Aliases;
        }

        public void setAliases (String aliases){
            Aliases = aliases;
        }

        public Date getCreationDate () {
            return CreationDate;
        }

        public void setCreationDate (Date creationDate){
            CreationDate = creationDate;
        }

        public String getStatus () {
            return Status;
        }

        public void setStatus (String status){
            Status = status;
        }

    }


