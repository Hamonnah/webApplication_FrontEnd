package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private String productCategory;
    private String productName;
    private BigDecimal price;

    public Product(String productCategory, String productName, BigDecimal price) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.price = price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(productCategory, product.productCategory) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCategory, productName, price);
    }
}
