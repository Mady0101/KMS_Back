package com.example.kms.Service;

import com.example.kms.dao.CryptoKeyRepository ;
import com.example.kms.model.CryptoKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;
import java.util.UUID;


@Component
public class KeyService {
    @Autowired
    CryptoKeyRepository cryptoKeyRepository ;



    public List<CryptoKey> getKeyByID (UUID id ) {

        return  cryptoKeyRepository.getCryptokeyByCustomerID(id) ;
    }

}



