package com.shopery.vendor.inventory.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transactionId;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private AppUsers vendor;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status; // PENDING, COMPLETED, FAILED

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(nullable = false)
    private boolean isDeleted = false; // Soft delete flag

    // Lifecycle hook to set default transaction date
    @PrePersist
    private void onCreate() {
        if (transactionDate == null) {
            transactionDate = new Date(); // Set the current date if not provided
        }
        if (createdAt == null) {
            createdAt = new Date(); // Ensure createdAt is set
        }
    }

    // Lifecycle hook to update updatedAt on modifications
    @PreUpdate
    private void onUpdate() {
        updatedAt = new Date(); // Update the timestamp when modified
    }

    // Getters and Setters

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public AppUsers getVendor() {
        return vendor;
    }

    public void setVendor(AppUsers vendor) {
        this.vendor = vendor;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        if (amount != null && amount.compareTo(BigDecimal.ZERO) > 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
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

