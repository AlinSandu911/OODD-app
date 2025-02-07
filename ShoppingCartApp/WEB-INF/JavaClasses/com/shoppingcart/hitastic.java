package com.shoppingcart;
//This class is the main entry point for our shopping applcation.
//It integrates admin and user functionalities allowing for a smooth shopping system.
//Main features would be admin login/functionality, user login/signup, product management and it also has a modular design.


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class hitastic {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        AdminUser admin = new AdminUser("Alin", "adminpass");
        List<RegularUser> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        
        products.add(new Product("Banana", "Fruits", 30, 0.30));
        products.add(new Product("Biscuits", "Snacks", 50, 1.50));
        products.add(new Product("Milk", "Dairy", 20, 1.20));
        products.add(new Product("Bread", "Bakery", 15, 0.80));

        while (true) {
            System.out.println("\nWelcome to our Shopping Cart System!");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Sign Up");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleAdminLogin(admin, products, scanner);
                    break;
                case 2:
                    handleUserLogin(users, products, scanner);
                    break;
                case 3:
                    handleUserSignUp(users, scanner);
                    break;
                case 4:
                    System.out.println("Thank you for visiting. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleAdminLogin(AdminUser admin, List<Product> products, Scanner scanner) {
        System.out.print("Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Admin Password: ");
        String password = scanner.nextLine();

        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            adminMenu(admin, products, scanner);
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    private static void handleUserLogin(List<RegularUser> users, List<Product> products, Scanner scanner) {
        System.out.print("User Username: ");
        String username = scanner.nextLine();
        System.out.print("User Password: ");
        String password = scanner.nextLine();

        RegularUser user = users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (user != null) {
            userMenu(user, products, scanner);
        } else {
            System.out.println("Invalid user credentials.");
        }
    }

    private static void handleUserSignUp(List<RegularUser> users, Scanner scanner) {
        System.out.print("New Username: ");
        String username = scanner.nextLine();
        System.out.print("New Password: ");
        String password = scanner.nextLine();

        users.add(new RegularUser(username, password));
        System.out.println("User signed up successfully!");
    }

    private static void adminMenu(AdminUser admin, List<Product> products, Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Update Product Stock");
            System.out.println("4. Delete Product");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    products.forEach(Product::displayProduct);
                    break;
                case 2:
                    addNewProduct(admin, products, scanner);
                    break;
                case 3:
                    updateProductStock(admin, products, scanner);
                    break;
                case 4:
                    deleteProduct(admin, products, scanner);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void userMenu(RegularUser user, List<Product> products, Scanner scanner) {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View All Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. View Past Orders");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    products.forEach(Product::displayProduct);
                    break;
                case 2:
                    addToCart(user, products, scanner);
                    break;
                case 3:
                    user.viewCart();
                    break;
                case 4:
                    user.checkout();
                    break;
                case 5:
                    user.viewPastOrders();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addNewProduct(AdminUser admin, List<Product> products, Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter stock quantity: ");
        int stock = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        admin.addProduct(products, new Product(name, category, stock, price));
    }

    private static void updateProductStock(AdminUser admin, List<Product> products, Scanner scanner) {
        System.out.print("Enter product name to update stock: ");
        String name = scanner.nextLine();
        Product product = findProductByName(products, name);

        if (product != null) {
            System.out.print("Enter new stock quantity: ");
            int stock = scanner.nextInt();
            scanner.nextLine();
            admin.updateStock(product, stock);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void deleteProduct(AdminUser admin, List<Product> products, Scanner scanner) {
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();
        Product product = findProductByName(products, name);

        if (product != null) {
            admin.deleteProduct(products, product);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void addToCart(RegularUser user, List<Product> products, Scanner scanner) {
        System.out.print("Enter product name, please: ");
        String name = scanner.nextLine();
        Product product = findProductByName(products, name);

        if (product != null) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            user.addToCart(product, quantity);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static Product findProductByName(List<Product> products, String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
