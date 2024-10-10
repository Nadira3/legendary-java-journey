package com.precious;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    // For demonstration purposes, hardcoded values. In production, use a database.
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password"; // Ideally, this should be hashed

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve user inputs
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate credentials
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            // Successful login, redirect to home page or dashboard
            response.sendRedirect("jsp/bankHome.jsp"); // Ensure home.jsp exists
        } else {
            // Login failed, set error message and forward back to login page
            request.setAttribute("errorMessage", "Invalid credentials");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }
}
