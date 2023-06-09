package com.eazybytes.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /*
        *   Below is the custom security configurations
        * */

        http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                .requestMatchers("/notices","/contact").permitAll()
                .and().httpBasic();

        return http.build();


        /*
        *   Configuration to deny all the requests
        * */

       /* http
                .authorizeHttpRequests()
                .anyRequest()
                .denyAll()
                .and().formLogin()
                .and().httpBasic();

        return http.build();*/

        /*
         *   Configuration to deny all the requests
         * */
        /*http
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
                .and().formLogin()
                .and().httpBasic();

        return http.build();*/


    }

}
