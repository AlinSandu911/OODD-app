package com.shoppingcart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the current session
        HttpSession session = request.getSession();

        // Retrieve the cart (List of Products) from the session
        @SuppressWarnings("unchecked")
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        // If no cart exists, create a new one and set it in the session
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        // Get product details from the request
        String productName = request.getParameter("productName");
        String category = request.getParameter("category");
        int stock = Integer.parseInt(request.getParameter("stock"));
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a new Product object and add it to the cart
        if (productName != null && category != null) {
            Product product = new Product(productName, category, stock, price);
            cart.add(product);
        }

        // Redirect to the cart page
        response.sendRedirect("cart.jsp");
    }
}
