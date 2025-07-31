package com.ochwada.orderservice.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.*;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.model
 * File: Order.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 12:01 PM
 * Description: Order document to be stored in MongoDB.
 * - Includes timestamp and list of ordered items.
 * *******************************************************
 */

@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * Unique identifier for the order.
     */
    @Id
    private String id;

    /**
     * The date and time when the order was created.
     */
    private LocalDateTime createdAt;

    /**
     * The list of items included in the order.
     */
    private List<OrderLineItem> items;

}
