package com.example.kms.api;

import com.example.kms.Service.CreatingKey;
import com.example.kms.Service.DistributionService;
import com.example.kms.model.CryptoKey;
import com.example.kms.model.Response;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin

@RestController
@RequestMapping(value = "/key")
public class KeyController {

    @Autowired
    private CreatingKey creatingKey;
    
    @Autowired 
    private DistributionService distributionService;
    
    

    @PostMapping("/generate")
    public CryptoKey generateKey(@RequestBody CryptoKey cryptoKey){
        System.out.println(cryptoKey.toString());
        return creatingKey.generateKey(cryptoKey.getKeyName(),cryptoKey.getAliases(),cryptoKey.getStatus());
    }
    
    @PostMapping("/distributeKey/emailNsms")
    public ResponseEntity<Response> distributeWithEmail(@RequestBody HashMap<String , String> request){
    	String emailTo = request.get("emailTo");
    	if (emailTo == null) 
			return new ResponseEntity<Response>(new Response("missing emailTo attribute"), HttpStatus.BAD_REQUEST);
    	
    	String phoneTo = request.get("phoneTo");
    	if (phoneTo == null)
    		return new ResponseEntity<Response>(new Response("missing phoneTo attribute"), HttpStatus.BAD_REQUEST);
    	
    	String subject = request.get("subject");
    	if (subject == null)
    		return new ResponseEntity<Response>(new Response("missing subject attribute"), HttpStatus.BAD_REQUEST);
    	
    	String key = request.get("key");
    	if (key == null)
    		return new ResponseEntity<Response>(new Response("missing key attribute"), HttpStatus.BAD_REQUEST);
    	
    	distributionService.distributeWithEmailAndSms(emailTo, phoneTo , subject, key);
    	return new ResponseEntity<Response>(new Response("Key distributed with the key value"),HttpStatus.OK);
    }
}


