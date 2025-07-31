package com.ochwada.orderservice.dto.request;


import jakarta.validation.constraints.*;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.dto.request
 * File: OrderItemRequest.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 12:07 PM
 * Description :Represents a single item in an order request.
 * - Contains the product ID and the quantity requested.
 * *******************************************************
 */

public record OrderItemRequest (

        /**
         * The ID of the product to order.
         * Must not be null.
         */
        @NotNull Long productId,

        /**
         * Quantity of the product to order.
         * Must be at least 1.
         */
        @Min(1) int quantity
){}