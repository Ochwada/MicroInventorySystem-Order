package com.ochwada.orderservice.service.client;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.service.client
 * File: InventoryClient.java
 * Author: Ochwada
 * Date: Thursday, 31.Jul.2025, 2:09 PM
 * Description: REST client to communicate with Inventory-Service.
 * - Should verify stock availability before placing an order.
 * *******************************************************
 */

@Component
@RequiredArgsConstructor
public class InventoryClient {

    /**
     * The HTTP client used to send requests to external services.
     */
    private final RestTemplate restTemplate;


    /**
     * The base URL of the inventory service.
     * Injected from the application configuration using the property {@code inventory.service.port}.
     */
    @Value("${inventory.service.url}")
    private String inventoryServiceUrl;

    /**
     *  Sends a GET request to the inventory-service to check stock availability.
     *
     * @param productId the ID of the product to check
     * @return true if the stock is available (quantity > 0), false otherwise
     */
    public boolean isStockSufficient(Long productId){
        // Retrieve available quantity from the Inventory Service
        Integer quantity = restTemplate.getForObject(
                inventoryServiceUrl + "/" + productId,
                Integer.class
        );

        // Return true if stock is sufficient
        return quantity != null && quantity > 0;
    }

    /**
     * Sends a GET request to the inventory-service to retrieve the current stock quantity.
     *
     * @param productId the ID of the product to check
     * @return the current stock quantity, or 0 if unavailable
     */
    public int getStockQuantity(Long productId){
        Integer quantity = restTemplate.getForObject(
                inventoryServiceUrl + "/" + productId,
                Integer.class
        );

        return  quantity != null ? quantity : 0;
    }

    /**
     * Sends a POST request to the inventory-service to reduce the current stock quantity.
     *
     * @param productId the ID of the product to decrease
     * @param quantity the quantity to reduce from inventory
     */
    public void decreaseStock(Long productId, int quantity){
        InventoryRequest request = new InventoryRequest(productId, quantity);

        restTemplate.postForObject(
                inventoryServiceUrl + "/api/inventory" + productId,
                request,
                Void.class
        );
    }

    // =============================== RECORDS ============================
    public record InventoryRequest(Long productId, int quantity) {}

    // ====================================================================

}
