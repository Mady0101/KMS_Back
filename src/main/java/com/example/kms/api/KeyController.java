package com.example.kms.api;

import com.example.kms.Service.CreatingKey;
import com.example.kms.Service.DistributionService;
import com.example.kms.model.CryptoKey;
import com.example.kms.model.Response;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.kms.Service.KeyService ;

@CrossOrigin

@RestController
@RequestMapping(value = "/key")
public class KeyController {

    @Autowired
    private CreatingKey creatingKey;
    
    @Autowired 
    private DistributionService distributionService;


    @Autowired
	KeyService keyService ;
	@GetMapping(value = "/getKey/{Customer_id}")
	public List<CryptoKey> getKeys(@PathVariable ("Customer_id") UUID id ) {return keyService.getKeyByID(id) ; }  ;

    

    @PostMapping("/generate")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public CryptoKey generateKey(@RequestBody CryptoKey cryptoKey){
        System.out.println(cryptoKey.toString());
        return creatingKey.generateKey(cryptoKey.getKeyName(),cryptoKey.getAliases(),cryptoKey.getStatus(), cryptoKey.getCustomer().getId());
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


