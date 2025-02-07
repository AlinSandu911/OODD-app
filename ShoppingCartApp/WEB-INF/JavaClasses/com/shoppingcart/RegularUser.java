package com.shoppingcart;
// This class extends the User class and represents users in the cart app.
// Features order history, stock handling and management of the shopping cart.
// Methods used: addToCart, checkout, viewCart and viewPastOrders.



import java.util.ArrayList;
import java.util.List;

class RegularUser extends User {
    private List<Product> cart;
    private List<Product> pastOrders;

    public RegularUser(String username, String password) {
        super(username, password);
        this.cart = new ArrayList<>();
        this.pastOrders = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            product.reduceStock(quantity);
            for (int i = 0; i < quantity; i++) {
                cart.add(product);
            }
            System.out.println(quantity + " " + product.getName() + "(s) added to your cart.");
        } else {
            System.out.println("Not enough stock for " + product.getName());
        }
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        pastOrders.addAll(cart);
        cart.clear();
        System.out.println("Checkout successful! Your cart is now empty.");
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("Your Cart:");
        for (Product product : cart) {
            product.displayProduct();
        }
    }

    public void viewPastOrders() {
        if (pastOrders.isEmpty()) {
            System.out.println("No past orders.");
            return;
        }
        System.out.println("Your Past Orders:");
        for (Product product : pastOrders) {
            product.displayProduct();
        }
    }

    public List<Product> getCart() { return cart; }
    public List<Product> getPastOrders() { return pastOrders; }
}
