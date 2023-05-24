package com.dalmia.dalmia;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DalmiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DalmiaApplication.class, args);
	}
	


}
