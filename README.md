# 🛒 MicroInventorySystem - Order

---
#### [Microservice 1: Product Service](https://github.com/Ochwada/MicroInventorySystem-Product)
#### [Microservice 2: Inventory Service](https://github.com/Ochwada/MicroInventorySystem-Inventory)
#### [Microservice 3: Order Service](https://github.com/Ochwada/MicroInventorySystem-Order)
#### [Microservice 4: Notification Service](https://github.com/Ochwada/MicroInventorySystem-Notification)

---

## Microservice 3: Order Service - Overview

A core component of a microservices-based inventory management system that handles the processing and management of 
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


## 📁 Project Structure
```yaml
micro-inventory-system/                        # 📦 Root of the Microservices System
├── docker-compose.yml                         # Central orchestration of all services
├── .env                                       # Global env config (e.g., DB URLs, credentials)
├── README.md                                  # System-level documentation
│
├── order-service/                             # 🧩 Microservice 3: Order Service (Spring Boot + JPA)
│   ├── .mvn/                                   # Maven wrapper files
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com.ochwada.orderservice/   # Root Java package
│   │       │       ├── config/                 # Spring beans and configuration
│   │       │       │   └── AppConfig.java
│   │       │       ├── controller/             # REST controllers (HTTP entrypoints)
│   │       │       │   └── OrderController.java
│   │       │       ├── dto/                    # Data Transfer Objects
│   │       │       │   ├── request/            # Incoming payloads
│   │       │       │   │   ├── CreateOrderRequest.java
│   │       │       │   │   └── OrderItemRequest.java
│   │       │       │   └── response/           # Outgoing responses
│   │       │       │       ├── OrderLineItemResponse.java
│   │       │       │       └── OrderResponse.java
│   │       │       ├── mapper/                 # Maps between entities and DTOs
│   │       │       │   └── OrderMapper.java
│   │       │       ├── model/                  # JPA entities
│   │       │       │   ├── Order.java
│   │       │       │   └── OrderLineItem.java
│   │       │       ├── repository/             # JPA repositories
│   │       │       │   └── OrderRepository.java
│   │       │       ├── service/                # Business logic layer
│   │       │       │   ├── client/             # External service clients (e.g., inventory)
│   │       │       │   │   └── InventoryClient.java
│   │       │       │   └── impl/               # Service implementations
│   │       │       │       ├── OrderServiceImpl.java
│   │       │       │       └── OrderService.java
│   │       │       └── OrderServiceApplication.java  # Spring Boot entrypoint
│   │       └── resources/
│   │           └── application.properties      # Microservice configuration
│   ├── pom.xml                                 # Maven build file
│   ├── Dockerfile                              # Container image definition
│   ├── .env                                    # Local environment config
│   ├── docker-compose.yml                      # (Optional) Compose config just for this service
│   └── README.md                               # Microservice-level documentation
│
├── product-service/                            # 🧩 Microservice 1: Product Service
│   └── ...
│
├── inventory-service/                          # 🧩 Microservice 2: Inventory Service
│   └── ...
│
└── external-libraries/                         # Shared or 3rd-party dependencies


```
## Dependencies 
| Dependency                         | Purpose                                                             |
|------------------------------------|---------------------------------------------------------------------|
| `spring-boot-starter-web`          | Provides REST API support (controllers, JSON, HTTP)                 |
| `spring-boot-starter-data-jpa`     | Enables Spring Data JPA for database access using ORM               |
| `spring-boot-starter-validation`   | Adds validation support (`@Valid`, `@NotNull`, `@Min`, etc.)        |
| `spring-boot-starter-openfeign` ⚙️ | Enables declarative REST clients to communicate with other services |
| `lombok`                           | Reduces boilerplate (getters, setters, constructors, etc.)          |
| `dotenv-java`                      | Loads environment variables from a `.env` file                      |
| `spring-boot-devtools` (optional)  | Enables hot reload during development                               |
| `spring-boot-starter-test`         | Adds testing support (JUnit, Mockito, etc.)                         |


#### Build Plugin
```bash

<build>
    <plugins>
     <!-- Spring Boot Maven Plugin -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>

```

