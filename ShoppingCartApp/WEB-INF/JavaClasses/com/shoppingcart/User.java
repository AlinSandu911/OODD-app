package com.shoppingcart;
// This page represents a user in the cart system.
// Features authentication and pass management.
// Main methods: getUsername, getPassword, setPassword.



public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
