package com.pkg.configuration;

import com.mongodb.client.MongoClient;
import com.pkg.jwtAuth.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.pkg.constants.ServiceConstants.VALUE_DATABASE;

/**
 * The type Security config.
 */
@Configuration
public class SecurityConfig {

    @Value(VALUE_DATABASE)
    private String database;

    /**
     * Security filter chain security filter chain.
     *
     * @param http      the http
     * @param jwtFilter the jwt filter
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Mongo template mongo template.
     *
     * @param mongoClient the mongo client
     * @return the mongo template
     */
    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, database);
    }
}