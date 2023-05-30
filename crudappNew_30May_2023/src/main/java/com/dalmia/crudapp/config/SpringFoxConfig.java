package com.dalmia.crudapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


//@Configuration
/*@EnableSwagger2
@Import(value = {SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})*/
public class SpringFoxConfig {

    /*@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }*/


    // configure as part of a class that extends WebMvcConfigurerAdapter and is annotated with @EnableWebMvc:
//    @Override
    /*public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*/

}
