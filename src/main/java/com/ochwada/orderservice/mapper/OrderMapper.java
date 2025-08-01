package com.ochwada.orderservice.mapper;


import com.ochwada.orderservice.dto.request.CreateOrderRequest;
import com.ochwada.orderservice.dto.response.OrderLineItemResponse;
import com.ochwada.orderservice.dto.response.OrderResponse;
import com.ochwada.orderservice.model.Order;
import com.ochwada.orderservice.model.OrderLineItem;
import com.ochwada.orderservice.service.client.InventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.mapper
 * File: OrderMapper.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 3:05 PM
 * Description: Manual mapper for converting between order DTOs and entities.
 * - {@code OrderMapper}  is responsible for converting between Order-related DTOs and entity models.
 * *******************************************************
 */

/**
 * This includes mapping:
 * - {@link CreateOrderRequest} ➝ {@link Order}
 * - {@link Order} ➝ {@link OrderResponse}
 * Used by {@code OrderServiceImpl} to translate client input into persistent models, and vice versa.
 */
@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final InventoryClient client;




    /**
     * Converts a CreateOrderRequest DTO into an Order entity.
     * The createdAt and id fields are not set here and should be assigned externally. (input)
     *
     * @param request the request DTO containing product IDs and quantities
     * @return an Order entity ready for persistence
     */
    public Order toEntity(CreateOrderRequest request) {


        List<OrderLineItem> items = request.items()
                .stream()
                .map(
                        item -> new OrderLineItem(
                                item.productId(),
                                item.quantity()
                        )
                ).toList();

        return new Order( items); // id & createdAt set later
    }

    /**
     * Converts an Order entity into an OrderResponse DTO.
     * This prepares order data for API responses. (output)
     *
     * @param order the persisted order entity
     * @return a response DTO containing order ID, creation time, and item details
     */
    public OrderResponse toResponse(Order order) {

        List<OrderLineItemResponse> itemResponses = order.getItems()
                .stream()
                .map(
                        item -> new OrderLineItemResponse(
                                item.getProductId(),
                                item.getQuantity()
                        )
                ).toList();

        return new OrderResponse(
                order.getId(),
                order.getCreatedAt(),
                itemResponses
        );
    }
}
