package com.shopery.vendor.inventory.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderDetailsDto {


    private UUID orderId;
    private UUID productId;
    private int quantity;


    // Getters and Setters


    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }





    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
