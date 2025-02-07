package com.shoppingcart;
// This page represents the admin user and its functionalities in our shopping cart system.
// The admin can update the inventory, add, remove any products.


import java.util.List;

class AdminUser extends User {
    public AdminUser(String username, String password) {
        super(username, password);
    }

    
    public void addProduct(List<Product> products, Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

   
    public void updateStock(Product product, int newStock) {
        product.reduceStock(-newStock); 
        System.out.println("Updated stock for " + product.getName() + ": " + product.getStock());
    }

    
    public void deleteProduct(List<Product> products, Product product) {
        if (products.remove(product)) {
            System.out.println("Product removed: " + product.getName());
        } else {
            System.out.println("Product not found.");
        }
    }
}

