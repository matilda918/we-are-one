package com.data.demo61.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSecurity {
    @Bean
    public PasswordEncoder passwordEnCoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/account/**").hasRole("ADMIN")
                        .requestMatchers("/courses/**").hasRole("ADMIN")
                        .requestMatchers("/certificate").permitAll()
                        .requestMatchers("/lession/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic();

        return http.build();

    }


}
