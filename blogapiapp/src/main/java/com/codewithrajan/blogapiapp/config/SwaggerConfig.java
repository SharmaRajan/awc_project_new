package com.codewithrajan.blogapiapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    // 1st step
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                            .apiInfo(getInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    public ApiInfo getInfo(){
        return new ApiInfo("Blogging Application", "This project is developed using Spring Boot",
                "v1.0.0", "Terms of Service 2023",
                new Contact("Rajan Sharma", "http://www.google.com/rajan/blogging-app","rajan@gmail.com"),
                "License",
                "API License URL", Collections.EMPTY_LIST);
    }

}
