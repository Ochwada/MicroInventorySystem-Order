package com.ochwada.orderservice.repository;


import com.ochwada.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.repository
 * File: OrderRepository.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 2:06 PM
 * Description: Repository interface to interact with MongoDB Atlas.
 * *******************************************************
 */


public interface OrderRepository extends MongoRepository<Order, String> {
}
