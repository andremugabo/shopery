package com.shopery.vendor.inventory.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUsers user; // Notification is for a specific user

    @Column(nullable = false)
    private String message; // Content of the notification

    @Enumerated(EnumType.STRING)
    private NotificationType type; // INFO, WARNING, ERROR, etc.

    @Enumerated(EnumType.STRING)
    private NotificationStatus status; // READ, UNREAD

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date(); // When the notification was created

    @Temporal(TemporalType.TIMESTAMP)
    private Date readAt; // When the notification was read (nullable)

    @Column(nullable = false)
    private boolean isDeleted = false; // Soft delete flag

    // Lifecycle hook to update `readAt` when status is set to READ
    @PreUpdate
    private void onUpdate() {
        if (this.status == NotificationStatus.READ && this.readAt == null) {
            this.readAt = new Date();
        }
    }

    // Getters and Setters
    public UUID getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(UUID notificationId) {
        this.notificationId = notificationId;
    }

    public AppUsers getUser() {
        return user;
    }

    public void setUser(AppUsers user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getReadAt() {
        return readAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}

