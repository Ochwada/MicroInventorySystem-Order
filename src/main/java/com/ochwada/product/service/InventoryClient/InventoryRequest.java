package com.ochwada.product.service.InventoryClient;


/**
 * Represents a request to check or update inventory for a specific product and quantity.
 *
 * @param productId the ID of the product
 * @param quantity  the quantity of the product involved in the inventory operation
 */
public record InventoryRequest(Long productId, int quantity) {
}
