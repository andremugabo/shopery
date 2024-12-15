package com.shopery.vendor.inventory.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shops")
public class Shops {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID shopId;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private AppUsers vendor; // A vendor who owns the shop

    @Column(nullable = false)
    private String shopName;

    private String shopAddress;

    @Column(nullable = true)
    private String shopLogo; // URL or path to the shop logo

    @Column(nullable = false)
    private String shopSpecialisation; // Shop specialization category

    @Column(nullable = true)
    private Double latitude; // Shop's geo-location latitude

    @Column(nullable = true)
    private Double longitude; // Shop's geo-location longitude

    @Column(nullable = false)
    private Date createdAt = new Date();
    private Date updatedAt;

    @PreUpdate
    private void onUpdate() {
        updatedAt = new Date();
    }

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Products> products = new ArrayList<>();

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>(); // Track orders associated with this shop


    // Getters and Setters
    public UUID getShopId() {
        return shopId;
    }

    public void setShopId(UUID shopId) {
        this.shopId = shopId;
    }

    public AppUsers getVendor() {
        return vendor;
    }

    public void setVendor(AppUsers vendor) {
        this.vendor = vendor;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

}
