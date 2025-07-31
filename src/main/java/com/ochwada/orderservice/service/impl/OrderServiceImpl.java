package com.ochwada.orderservice.service.impl;


import com.ochwada.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.service.impl
 * File: OrderServiceImpl.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 2:52 PM
 * Description: Service implementation containing the business logic for placing orders.
 * *******************************************************
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl {
    private final OrderRepository repository;

}
