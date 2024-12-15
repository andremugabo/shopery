package com.shopery.vendor.inventory.dto;


import com.shopery.vendor.inventory.models.Orders;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public class ShopDto {
    private UUID shopId;
    private String shopName;
    private String shopAddress;
    private String shopLogo;
    private String shopSpecialisation;
    private UUID vendorId;
    private Double latitude;
    private Double longitude;
    private Orders orders;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    // Getters and Setters
    public UUID getShopId() {
        return shopId;
    }

    public void setShopId(UUID shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopSpecialisation() {
        return shopSpecialisation;
    }

    public void setShopSpecialisation(String shopSpecialisation) {
        this.shopSpecialisation = shopSpecialisation;
    }

    public UUID getVendorId() {
        return vendorId;
    }

    public void setVendorId(UUID vendorId) {
        this.vendorId = vendorId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

}
