package com.ochwada.orderservice.model;


import lombok.*;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.model
 * File: OrderLineItem.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 12:03 PM
 * Description: Represents a single product item in an order.
 * - Contains the product ID and the quantity ordered.
 * *******************************************************
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItem {
    /** The unique identifier of the product. */
    private Long productId;

    /** The quantity of the product ordered. */
    private int quantity;
}
