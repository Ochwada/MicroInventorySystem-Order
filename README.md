# 🛒 Order-Service Microservice

---
### [Microservice 1: Product Service](https://github.com/Ochwada/MicroInventorySystem-Product)
### [Microservice 2: Inventory Service](https://github.com/Ochwada/MicroInventorySystem-Inventory)
### [Microservice 3: Order Service](https://github.com/Ochwada/MicroInventorySystem-Order)
---

## Microservice 3: Order Service - Overview

A critical component of a microservices-based inventory management system that handles the processing and management of 
customer orders. It validates product availability by interacting with the **Inventory-Service** and stores order 
information in MongoDB Atlas. The service is designed with Spring Boot, utilizes Spring Data for MongoDB integration, 
and is fully containerized using Docker (multi-stage builds) for efficient deployment.


## Objective
Building an **Order microservice** that performs the following responsibilities:

- Accepts new product orders through RESTful APIs 
- Validates stock availability by communicating with the **Inventory-Service** 
- Persists validated order data into **MongoDB Atlas** 
- Implements input validation and error handling 
- Is containerized using **multi-stage Docker builds** for lean deployment


## Dependencies

| Dependency                         | Purpose                                                                       |
|------------------------------------|-------------------------------------------------------------------------------|
| `spring-boot-starter-data-mongodb` | Enables integration with MongoDB via Spring Data                              |
| `spring-boot-starter-validation`   | Adds support for `javax.validation` annotations (`@NotBlank`, `@Valid`, etc.) |
| `spring-boot-starter-web`          | Enables web-related features (REST APIs, controllers, etc.)                   |
| `lombok`                           | Reduces boilerplate (getters/setters, constructors, etc.)                     |
| `dotenv-java`                      | Loads environment variables from a `.env` file at runtime                     |

#### Build Plugin
```yaml

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>

```