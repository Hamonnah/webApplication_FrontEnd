package com.example.demo.domain;

import java.util.Objects;

public class Order {

    private String clinic;
    private String dentist;
    private Long scanId;
    private String productCategory;
    private String productName;
    private int quantity;
    private OrderType type;

    public Order() {
    }

    public Order(String clinic, String dentist, Long scanId, String productCategory, String productName, int quantity, OrderType type) {
        this.clinic = clinic;
        this.dentist = dentist;
        this.scanId = scanId;
        this.productCategory = productCategory;
        this.productName = productName;
        this.quantity = quantity;
        this.type = type;
    }

    public String getClinic() {
        return clinic;
    }

    public String getDentist() {
        return dentist;
    }

    public Long getScanId() {
        return scanId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return quantity == order.quantity &&
                Objects.equals(clinic, order.clinic) &&
                Objects.equals(dentist, order.dentist) &&
                Objects.equals(scanId, order.scanId) &&
                Objects.equals(productCategory, order.productCategory) &&
                Objects.equals(productName, order.productName) &&
                type == order.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clinic, dentist, scanId, productCategory, productName, quantity, type);
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public void setDentist(String dentist) {
        this.dentist = dentist;
    }

    public void setScanId(Long scanId) {
        this.scanId = scanId;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setType(OrderType type) {
        this.type = type;
    }
}
