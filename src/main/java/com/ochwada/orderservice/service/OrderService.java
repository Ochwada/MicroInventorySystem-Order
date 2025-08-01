package com.ochwada.orderservice.service;


import com.ochwada.orderservice.dto.request.CreateOrderRequest;
import com.ochwada.orderservice.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.service
 * File: OrderService.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 2:56 PM
 * Description: Service layer for order operations. Service class for handling business logic related to orders
 * *******************************************************
 */

@Service
public interface OrderService {
    List<OrderResponse> getAllOrders();
    OrderResponse placeOrder(CreateOrderRequest request);


}
