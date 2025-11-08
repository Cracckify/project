package com.cracikify.amazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		System.out.println("My first springboot application");
		
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
