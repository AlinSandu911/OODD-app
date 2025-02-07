<%@ page import="com.shoppingcart.Product, java.util.List, java.util.ArrayList" %>


<html>
<head>
    <title>Available Products</title>
</head>
<body>
    <h2>Products</h2>
    <%
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 5, 999.99));
        products.add(new Product("Phone", "Electronics", 10, 499.99));
        products.add(new Product("Headphones", "Accessories", 20, 79.99));
    %>
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <% for (Product p : products) { %>
        <tr>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
            <td>
                <form action="CartServlet" method="post">
                    <input type="hidden" name="productName" value="<%= p.getName() %>">
                    <input type="hidden" name="productPrice" value="<%= p.getPrice() %>">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <a href="cart.jsp">View Cart</a>
</body>
</html>
