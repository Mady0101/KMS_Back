package com.example.kms;

import com.example.kms.model.Aes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmsApplication.class, args);
		Aes aes = new Aes();
		String text = "My Name is Aziz ";
		String cipherText = aes.encrypt(text);
		System.out.println(cipherText);
		System.out.println(aes.decrypt(cipherText));
	}
}

