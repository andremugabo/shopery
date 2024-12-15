package com.shopery.vendor.inventory.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID paymentId;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; // CARD, CASH, BANK_TRANSFER, MOMO

    private BigDecimal amountPaid;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(nullable = false)
    private boolean isDeleted = false; // Soft delete flag

    @PrePersist
    private void onCreate() {
        if (paymentDate == null) {
            paymentDate = new Date(); // Default to current time if not provided
        }
        if (createdAt == null) {
            createdAt = new Date(); // Ensure createdAt is set
        }
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = new Date(); // Update the timestamp on each modification
    }

    // Getters and Setters

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        if (amountPaid != null && amountPaid.compareTo(BigDecimal.ZERO) > 0) {
            this.amountPaid = amountPaid;
        } else {
            throw new IllegalArgumentException("Amount paid must be greater than zero.");
        }
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
