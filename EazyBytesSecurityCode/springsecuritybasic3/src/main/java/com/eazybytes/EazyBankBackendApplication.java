package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// If package is outside the main spring application package then we have to explicitly configure those packages
//@ComponentScan("com.eazybytes.springsecuritybasic.controller")// Optional.

// If package is outside the main spring application then
//@EnableJpaRepositories("com.eazybytes.repository")
//@EntityScan("com.eazybytes.model")
public class EazyBankBackendApplication{

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

}
