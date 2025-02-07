package com.shoppingcart; // Package declaration must be the first line

import java.io.Serializable; // Import statement follows the package declaration

// Represents an item in the shopping cart system
// Includes stock management and product information
public class Product implements Serializable {
    private static final long serialVersionUID = 1L; // Required for serialization
    private String name;
    private String category;
    private int stock;
    private double price;

    // Full Constructor
    public Product(String name, String category, int stock, double price) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    // Optional No-Argument Constructor (useful for frameworks or reflection-based libraries)
    public Product() {}

    // Reduces stock when an item is purchased
    public void reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            throw new IllegalArgumentException("Not enough stock available.");
        }
    }

    // Displays product information in the console (for debugging purposes)
    public void displayProduct() {
        System.out.println("Name: " + name + ", Category: " + category + ", Stock: " + stock + ", Price: £" + price);
    }

    // Getter and Setter methods (adheres to JavaBean standards)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
