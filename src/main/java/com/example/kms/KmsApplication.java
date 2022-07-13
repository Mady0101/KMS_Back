package com.example.kms;

import com.example.kms.Service.SendEmailService;
import com.example.kms.Service.TwilioSendSmsService;
import com.example.kms.Service.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class KmsApplication {

	@Autowired
	private SendEmailService ses;
	@Autowired
	private TwilioSendSmsService sendSmsService ;

	public static void main(String[] args) {
		SpringApplication.run(KmsApplication.class, args);
		Aes aes = new Aes();
		String text = "My Name is Aziz ";
		String cipherText = aes.encrypt(text);
		System.out.println(cipherText);
		System.out.println(aes.decrypt(cipherText));

	}



	@EventListener(ApplicationReadyEvent.class)

	public void sendSms () {

		sendSmsService.send(" +216 26800064","Hello");
		ses.sendSimpleMessage("mohamedaziz.jaidi@ensi-uma.tn", "test", "123456789");

	}


	}










