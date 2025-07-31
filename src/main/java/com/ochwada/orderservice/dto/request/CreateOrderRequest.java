package com.ochwada.orderservice.dto.request;


import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.dto.request
 * File: CreateOrderRequest.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 12:16 PM
 * Description: Request DTO to receive order creation input.
 * - * Includes a list of product items.
 * *******************************************************
 */


public record CreateOrderRequest(
        /**
         * List of items in the order request.
         * Must not be null.
         */
        @NotNull List<OrderItemRequest> Items

        ) { }
