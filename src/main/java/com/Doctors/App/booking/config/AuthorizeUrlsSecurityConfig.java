package com.Doctors.App.booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.web.SecurityFilterChain;



@Configuration
 @EnableWebSecurity
 public class AuthorizeUrlsSecurityConfig {

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
             .authorizeHttpRequests()
                 .requestMatchers("/**").hasRole("USER")
                 .requestMatchers("/admin/**").hasRole("ADMIN")
                 .and()
             .formLogin();
         return http.build();
     }
 }