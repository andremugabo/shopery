package com.shopery.vendor.inventory.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class AppUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    private UserType userType; // CUSTOMER, VENDOR, ADMIN

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    private String address;

    private String password;


    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Shops> shops = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Orders> orders = new ArrayList<>();


    @Column(name = "is_deleted", nullable = false)
    private Boolean status = false;

    // Optional geo-location fields
    @Column(nullable = true)
    private Double latitude; // Geo-location latitude

    @Column(nullable = true)
    private Double longitude; // Geo-location longitude

    // 2FA related fields
    private Boolean isTwoFactorEnabled = false; // Flag to indicate if 2FA is enabled
    private String googleAuthenticatorSecret; // Google Authenticator secret key (if using TOTP)
    private Boolean isTwoFactorVerified = false; // To indicate if the user has verified 2FA

    // Getters and Setters
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<Shops> getShops() {
        return shops;
    }

    public void setShops(List<Shops> shops) {
        this.shops = shops;
    }

    public Boolean getTwoFactorEnabled() {
        return isTwoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
        isTwoFactorEnabled = twoFactorEnabled;
    }

    public Boolean getTwoFactorVerified() {
        return isTwoFactorVerified;
    }

    public void setTwoFactorVerified(Boolean twoFactorVerified) {
        isTwoFactorVerified = twoFactorVerified;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getIsTwoFactorEnabled() {
        return isTwoFactorEnabled;
    }

    public void setIsTwoFactorEnabled(Boolean isTwoFactorEnabled) {
        this.isTwoFactorEnabled = isTwoFactorEnabled;
    }

    public String getGoogleAuthenticatorSecret() {
        return googleAuthenticatorSecret;
    }

    public void setGoogleAuthenticatorSecret(String googleAuthenticatorSecret) {
        this.googleAuthenticatorSecret = googleAuthenticatorSecret;
    }

    public Boolean getIsTwoFactorVerified() {
        return isTwoFactorVerified;
    }

    public void setIsTwoFactorVerified(Boolean isTwoFactorVerified) {
        this.isTwoFactorVerified = isTwoFactorVerified;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
