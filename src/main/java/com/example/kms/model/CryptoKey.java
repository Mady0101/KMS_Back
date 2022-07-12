 package com.example.kms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;


@Entity
public class CryptoKey {
    public CryptoKey() {
    }

    @Id
        private UUID KeyId;
        @JsonProperty("keyName")
        private String KeyName;
        @JsonProperty("aliases")
        private String Aliases;
        private Date CreationDate;
        @JsonProperty("status")
        private String Status;

        private SecretKey generatedKey;


    public CryptoKey(String keyName, String aliases, Date creationDate, String status, SecretKey generatedKey) {
        KeyName = keyName;
        Aliases = aliases;
        CreationDate = creationDate;
        Status = status;
        this.generatedKey = generatedKey;
    }

    public SecretKey getGeneratedKey() {
        return generatedKey;
    }

    public void setGeneratedKey(SecretKey generatedKey) {
        this.generatedKey = generatedKey;
    }

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

    @Override
    public String toString() {
        return "CryptoKey{" +
                "KeyId=" + KeyId +
                ", KeyName='" + KeyName + '\'' +
                ", Aliases='" + Aliases + '\'' +
                ", CreationDate=" + CreationDate +
                ", Status='" + Status + '\'' +
                ", generatedKey=" + generatedKey +
                '}';
    }
}


