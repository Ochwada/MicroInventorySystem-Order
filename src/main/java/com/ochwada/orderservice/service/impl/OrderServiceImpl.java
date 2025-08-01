package com.ochwada.orderservice.service.impl;


import com.ochwada.orderservice.dto.request.CreateOrderRequest;
import com.ochwada.orderservice.dto.request.OrderItemRequest;
import com.ochwada.orderservice.dto.response.OrderLineItemResponse;
import com.ochwada.orderservice.dto.response.OrderResponse;
import com.ochwada.orderservice.mapper.OrderMapper;
import com.ochwada.orderservice.model.Order;
import com.ochwada.orderservice.repository.OrderRepository;
import com.ochwada.orderservice.service.OrderService;
import com.ochwada.orderservice.service.client.InventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final InventoryClient client;


    /**
     * Retrieves all saved orders from the database and maps them to response DTOs.
     *
     * @return list of all orders
     */
    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = repository.findAll();
        return orders.stream()
                .map(mapper::toResponse)
                .toList();
    }

    /**
     * Validates stock and saves order if valid.
     *
     * @param request the order creation request
     * @return the created order as a response DTO
     * @throws IllegalArgumentException if stock is insufficient for any item
     */
    @Override
    public OrderResponse placeOrder(CreateOrderRequest request) {
        // 1. Validate the stock
        for (OrderItemRequest item : request.items()) {
            int availableStock = client.getStockQuantity(item.productId());

            if (item.quantity() > availableStock) {
                throw new IllegalArgumentException(
                        "Insufficient stock for product ID: " + item.productId()
                );
            }
        }

        // 2.  Map request to Order entity (this converts item DTOs to entities).
        Order order = mapper.toEntity(request);

        // 3. Save to repository ( ID + createdAt set automatically (handled by JPA))
        Order savedOrder = repository.save(order);

        //  4. Reduce stock in inventory
        for (OrderItemRequest item : request.items()){
            client.decreaseStock(item.productId(), item.quantity());
        }

        // 4. Map back to response DTO
        List<OrderLineItemResponse> itemResponses = savedOrder.getItems()
                .stream()
                .map(
                        item -> new OrderLineItemResponse(
                                item.getProductId(),
                                item.getQuantity())
                )
                .toList();

        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.getCreatedAt(),
                itemResponses
        );
    }
}
