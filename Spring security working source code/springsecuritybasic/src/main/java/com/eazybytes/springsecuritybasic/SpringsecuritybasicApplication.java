package com.eazybytes.springsecuritybasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
// If package is outside the main spring application package then we have to explicitly configure those packages
//@ComponentScan("com.eazybytes.springsecuritybasic.controller")// Optional.
public class SpringsecuritybasicApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritybasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Encoded Jaadu: " + passwordEncoder.encode("Jaadu"));
	}
}
