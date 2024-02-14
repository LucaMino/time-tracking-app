package com.sideproject.timetrackingapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 
 */
@Configuration
public class SecurityConfig
{    
    /**
     * this method creates a bean that can be accessed everywhere in the project.
     * 
     * @return an instance of PasswordEncoder
     */
    @Bean
    public static PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }

    /**
     * creates a bean for the AuthenticationManager interface
     * 
     * @param configuration AuthenticationConfiguration instance used to retrieve the AuthenticationManager
     * @return an AuthenticationManager instance configured by the provided AuthenticationConfiguration
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception 
    {
        return configuration.getAuthenticationManager();
    }

    /**
     * Configures and returns a SecurityFilterChain bean.
     * 
     * @param http
     * @return
     * @throws Exception
     */
    /* @Bean    
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/api/**", "/h2-console/**") // allow access to specific URLs without authentication
            .permitAll()
            .anyRequest()
            .authenticated();

        http.headers()
            .frameOptions()
            .disable();

        // build and return the configured SecurityFilterChain
        return http.build();
    } */
}