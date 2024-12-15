package com.shopery.vendor.inventory.dto;

import java.util.List;
import java.util.UUID;

public class AppUsersDto {

    private UUID userId;
    private String userType; // CUSTOMER, VENDOR, ADMIN
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean status;
    private Double latitude;
    private Double longitude;

    // 2FA related fields
    private Boolean isTwoFactorEnabled; // To indicate if 2FA is enabled
    private Boolean isTwoFactorVerified; // To indicate if the user has verified 2FA

    // Password field
    private String password; // To store the user's password

    // Default constructor
    public AppUsersDto() {}

    // Parameterized constructor
    public AppUsersDto(UUID userId, String userType, String name, String email,
                       String phoneNumber, String address, Boolean status,
                       Double latitude, Double longitude, Boolean isTwoFactorEnabled,
                       Boolean isTwoFactorVerified, String password) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isTwoFactorEnabled = isTwoFactorEnabled;
        this.isTwoFactorVerified = isTwoFactorVerified;
        this.password = password;
    }

    public AppUsersDto(UUID userId, String name, String name1, String email, String phoneNumber, String address, Boolean status, Double latitude, Double longitude, Boolean isTwoFactorEnabled, Boolean isTwoFactorVerified) {
    }

    public AppUsersDto(UUID userId, String name, String name1, String email, String phoneNumber, String address, Boolean status, Double latitude, Double longitude, Boolean isTwoFactorEnabled, Boolean isTwoFactorVerified, Object o, String password) {
    }

    // Getters and Setters
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
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

    public Boolean getIsTwoFactorVerified() {
        return isTwoFactorVerified;
    }

    public void setIsTwoFactorVerified(Boolean isTwoFactorVerified) {
        this.isTwoFactorVerified = isTwoFactorVerified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getTwoFactorVerified() {
        return isTwoFactorVerified;
    }

    public void setTwoFactorVerified(Boolean twoFactorVerified) {
        isTwoFactorVerified = twoFactorVerified;
    }



    public Boolean getTwoFactorEnabled() {
        return isTwoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
        isTwoFactorEnabled = twoFactorEnabled;
    }
}
