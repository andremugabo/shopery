package com.shopery.vendor.inventory.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class OrdersDto {

    private UUID orderId;
    private UUID customerId;
    private String status; // PENDING, COMPLETED, CANCELLED
    private BigDecimal totalAmount;
    private UUID shopId; // Shop ID

    // Getters and Setters
    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }





    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }



    public UUID getShopId() {
        return shopId;
    }

    public void setShopId(UUID shopId) {
        this.shopId = shopId;
    }




}
