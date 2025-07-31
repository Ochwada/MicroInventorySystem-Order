package com.ochwada.orderservice.controller;


import com.ochwada.orderservice.dto.request.CreateOrderRequest;
import com.ochwada.orderservice.dto.response.OrderLineItemResponse;
import com.ochwada.orderservice.dto.response.OrderResponse;
import com.ochwada.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.controller
 * File: OrderController.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 4:30 PM
 * Description: REST controller for managing orders.
 * Objective: Exposes endpoints to create and retrieve orders.
 * *******************************************************
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    /**
     * Retrieves all orders.
     *
     * @return a list of {@link OrderResponse} representing all saved orders
     */
    @GetMapping
    public List<OrderResponse> getAllOrders(){
        return  service.getAllOrders();
    }

    /**
     * Creates a new order from the provided request body.
     * Validates input and delegates to the service layer.
     *
     * @param request the {@link CreateOrderRequest} containing order item details
     * @return the saved {@link OrderResponse}
     */
    @PostMapping
    public OrderResponse createOrder(@Valid CreateOrderRequest request){

        return service.placeOrder(request);
    }
}
