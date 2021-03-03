package com.example.demo.domain;

import java.util.Objects;

public class Order {

    private String clinic;
    private String dentist;
    private String scanId;
    //private String productCategory;
    //private String productName;
    //private int quantity;
    private OrderType type;

    public Order() {
    }

    public Order(String clinic, String dentist, String scanId, OrderType type) {
        this.clinic = clinic;
        this.dentist = dentist;
        this.scanId = scanId;
        this.type = type;
    }


    public String getClinic() {
        return clinic;
    }

    public String getDentist() {
        return dentist;
    }

    public String getScanId() {
        return scanId;
    }



    public OrderType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(clinic, order.clinic) &&
                Objects.equals(dentist, order.dentist) &&
                Objects.equals(scanId, order.scanId) &&
                type == order.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clinic, dentist, scanId, type);
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public void setDentist(String dentist) {
        this.dentist = dentist;
    }

    public void setScanId(String scanId) {
        this.scanId = scanId;
    }


    public void setType(OrderType type) {
        this.type = type;
    }
}
