<%@ page import="com.shoppingcart.Product, java.util.List, java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionObj = request.getSession(false);
    String username = (sessionObj != null) ? (String) sessionObj.getAttribute("username") : null;
    if (username == null || !"admin".equals(username)) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
    <h2>Welcome, Admin!</h2>
    <a href="logout.jsp">Logout</a>
</body>
</html>
