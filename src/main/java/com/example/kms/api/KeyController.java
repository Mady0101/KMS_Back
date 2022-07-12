package com.example.kms.api;

import com.example.kms.Service.CreatingKey;
import com.example.kms.model.CryptoKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin

@RestController
@RequestMapping(value = "/key")
public class KeyController {

    @Autowired
    CreatingKey cr;

    @PostMapping("/generate")
    public CryptoKey generateKey(@RequestBody CryptoKey cryptoKey){
        System.out.println(cryptoKey.toString());
        return cr.generateKey(cryptoKey.getKeyName(),cryptoKey.getAliases(),cryptoKey.getStatus());
    }
}
