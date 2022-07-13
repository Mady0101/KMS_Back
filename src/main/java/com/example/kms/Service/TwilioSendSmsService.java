package com.example.kms.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class TwilioSendSmsService {
	
	 	@Value("${twilio.accountSid}")
	    private String ACCOUNT_SID;

	    @Value("${twilio.authToken}")
	    private String AUTH_TOKEN;

	    @Value("${twilio.trialNumber}")
	    private String FROM_NUMBER;


	    public void send(String to , String msg) {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(FROM_NUMBER), msg)
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }

		

}

