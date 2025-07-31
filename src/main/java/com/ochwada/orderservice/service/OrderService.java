package com.ochwada.orderservice.service;


import com.ochwada.orderservice.dto.request.CreateOrderRequest;
import com.ochwada.orderservice.dto.request.OrderItemRequest;
import com.ochwada.orderservice.dto.response.OrderLineItemResponse;
import com.ochwada.orderservice.dto.response.OrderResponse;
import com.ochwada.orderservice.mapper.OrderMapper;
import com.ochwada.orderservice.model.Order;
import com.ochwada.orderservice.repository.OrderRepository;
import com.ochwada.orderservice.service.client.InventoryClient;
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
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final InventoryClient client;

    /**
     * Retrieves all orders from the database and maps them to DTOs.
     *
     * @return a list of {@link OrderResponse} representing all saved orders
     */
    public List<OrderResponse> getAllOrders() {

        List<Order> orders = repository.findAll();

        return orders.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    /**
     * Creates a new order from the given request, saves it to the database, and returns a DTO response.
     * The order ID and creation timestamp are automatically managed by the persistence layer.
     *
     * @param request the {@link CreateOrderRequest} containing order item details
     * @return an {@link OrderResponse} representing the saved order
     */
    public OrderResponse placeOrder(CreateOrderRequest request) {

        // Loop through items and validate stock
        for (OrderItemRequest item : request.items()) {
            // Assuming productId used for lookup
            int availableStock = client.getStockQuantity(item.productId());
            if (item.quantity() > availableStock) {
                throw new IllegalArgumentException(
                        "Insufficient stock for product ID: " + item.productId()
                );
            }
        }

        // Map request to Order entity
        // this converts item DTOs to entities
        Order order = mapper.toEntity(request);

        // Save to repository
        // ID + createdAt set automatically (handled by JPA)
        Order savedOrder = repository.save(order);

        // Map back to response DTO
        List<OrderLineItemResponse> responseItems = savedOrder.getItems()
                .stream()
                .map(
                        item -> new OrderLineItemResponse(
                                item.getProductId(),
                                item.getQuantity()
                        )
                ).toList();

        // Return mapped response
        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.getCreatedAt(),
                responseItems
        );
    }
}
