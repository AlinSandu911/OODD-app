<%@ page import="com.shoppingcart.<Product>, java.util.List, java.util.ArrayList" %>


<body>
    <h2>Your Shopping Cart</h2>
    <%
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
    %>
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Price</th>
        </tr>
        <% for (Product p : cart) { %>
        <tr>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
        </tr>
        <% } %>
    </table>
</body>
