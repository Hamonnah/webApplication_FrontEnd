package com.example.demo.domain;

import java.util.Objects;

public class Order {

    private String clinic;
    private String dentist;
    private Long scanId;
    private OrderType type;

    public Order() {
    }

    public Order(String clinic, String dentist, Long scanId, OrderType type) {
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

    public Long getscanId() {
        return scanId;
    }

    public OrderType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!scanId.equals(order.scanId)) return false;
        if (!Objects.equals(clinic, order.clinic)) return false;
        if (!Objects.equals(dentist, order.dentist)) return false;
        return Objects.equals(type, order.type);
    }

    @Override
    public int hashCode() {
        int result = clinic != null ? clinic.hashCode() : 0;
        result = 31 * result + (dentist != null ? dentist.hashCode() : 0);
        result = 31 * result + (scanId != null ? scanId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
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

    public void setType(OrderType type) {
        this.type = type;
    }
}
