package com.ochwada.orderservice.dto.response;


import com.ochwada.orderservice.model.OrderLineItem;

import java.time.LocalDateTime;
import java.util.List;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.dto.response
 * File: OrderResponse.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 12:13 PM
 * Description: Response DTO sent back when an order is placed.
 * *******************************************************
 */


public record OrderResponse(
        String id,
        LocalDateTime createdAt,
        List<OrderLineItemResponse> items

) { }
