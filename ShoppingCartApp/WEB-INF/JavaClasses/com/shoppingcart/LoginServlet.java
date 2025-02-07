package com.shoppingcart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Temporary Hardcoded Credentials (Replace with database logic later)
        if (("admin".equals(username) && "adminpass".equals(password)) || 
            ("user".equals(username) && "userpass".equals(password))) {
            
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            if ("admin".equals(username)) {
                response.sendRedirect("admin.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            response.getWriter().println("Invalid username or password. <a href='login.jsp'>Try again</a>");
        }
    }
}
