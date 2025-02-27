package com.shoppingcart;
// The page serves for managing the admin and regular users in the shopping app.
// Main methods used are signUp, login and getAdminUser functions.

import java.util.ArrayList;
import java.util.List;

class PointsOfInterestApp {
    protected List<RegularUser> regularUsers;
    private AdminUser adminUser;

    public PointsOfInterestApp() {
        this.regularUsers = new ArrayList<>();
        this.adminUser = new AdminUser("Alin", "adminpass");
    }

    public RegularUser signUp(String username, String password) {
        RegularUser newUser = new RegularUser(username, password);
        regularUsers.add(newUser);
        return newUser;
    }

    public RegularUser login(String username, String password) {
        for (RegularUser user : regularUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }
}

