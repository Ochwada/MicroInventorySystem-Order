package com.ochwada.orderservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice
 * File: OrderServiceApplication.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 10:58 AM
 * Description: Main entry point for the Order Service Application
 * *******************************************************
 */
@SpringBootApplication
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    //========================================================================
    // .env Configuration
    //========================================================================

    static {
        // Load environment variables from .env file
        // Ignores file if missing (useful for production environments like Heroku)
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        String[] envVars = {
                "PORT",
                "SPRING_DATA_MONGODB_URI",
                "INVENTORY_SERVICE_URL"
        };

        // Iterate through keys and set them as JVM system properties if found
        for (String key : envVars) {
            String value = dotenv.get(key);

            if (value != null) {
                System.setProperty(key, value);  // Makes it accessible via System.getProperty
                System.out.println("✅ " + key + " loaded and set.");

            } else {
                System.out.println("⚠️" + key + " not found in .env file. Skipping System.");
            }
        }
    }
    //========================================================================
}
