package com.ochwada.orderservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.client.RestTemplate;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.config
 * File: AppConfig.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 4:31 PM
 * Description: Configuration class for application-level beans.
 * - Define and expose reusable Spring-managed components that can be injected into other parts of the application.
 * *******************************************************
 */

@Configuration
@EnableMongoAuditing  // Enables @CreatedDate for MongoDB
public class AppConfig {
    /**
     * Creates and registers a {@link RestTemplate} bean.
     *
     * @return a new instance of {@code RestTemplate}
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
