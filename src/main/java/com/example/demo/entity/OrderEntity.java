package com.example.demo.entity;

import jakarta.persistence.Entity; // Import JPA annotations
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Marks this class as a JPA entity
public class OrderEntity {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates values for the primary key (auto-increment)
    private Long id;

    private String productName; // Name of the product ordered
    private double price; // Price of the product
    private int quantity; // Quantity of the product ordered
    private String name; // Customer's name
    private String street; // Street address of the customer
    private String city; // City of the customer
    private String zip; // ZIP code of the customer
    private String country; // Country of the customer
    private String paymentMethod; // Payment method used for the order

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
