package com.shopery.vendor.inventory.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order; // Parent order

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product; // Associated product

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private BigDecimal price;

    @Transient
    private BigDecimal subtotal; // Calculated dynamically

    @Column(nullable = false)
    private boolean isDeleted = false; // Soft delete

    @PostLoad
    private void calculateSubtotal() {
        if (price != null && quantity > 0) {
            this.subtotal = price.multiply(BigDecimal.valueOf(quantity));
        } else {
            this.subtotal = BigDecimal.ZERO; // Default if price or quantity is invalid
        }
    }

    // Getters and Setters
    public UUID getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(UUID orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = (price != null && price.compareTo(BigDecimal.ZERO) > 0) ? price : BigDecimal.ZERO;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
