package com.example.kms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DistributionService {
	
	@Autowired
	private SendEmailService ses;
	
	@Autowired
	private TwilioSendSmsService ts;
	
	
	public void distributeWithEmail(String toEmail, String subject, String text) {
		ses.sendSimpleMessage(toEmail , subject , text);
	}
	
	public void distributeWithSms(String toPhone, String text) {
		ts.send(toPhone, text);
	}
	
	
	public void distributeWithEmailAndSms(String toEmail, String toPhone, String subject, String text) {
		StringDivider sd = new StringDivider(text , 2);
		List<String> divided_strings = sd.divide();
		ses.sendSimpleMessage(toEmail, subject, divided_strings.get(0));
		ts.send(toPhone, divided_strings.get(1) );
	}

}
