package com.ochwada.orderservice.dto.response;


/**
 * *******************************************************
 * Package: com.ochwada.orderservice.dto.response
 * File: OrderLineItemResponse.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 2:04 PM
 * Description: A single item inside an order response.
 * *******************************************************
 */

public record OrderLineItemResponse(
        Long productId,
        int quantity
) {
}
