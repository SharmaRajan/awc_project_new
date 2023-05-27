package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// If package is outside the main spring application package then we have to explicitly configure those packages
//@ComponentScan("com.eazybytes.springsecuritybasic.controller")// Optional.
public class EazyBankBackendApplication{

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

}
