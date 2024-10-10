package com.precious;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// The @WebServlet annotation maps this servlet to the "/login" URL pattern.
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Validate the user's credentials (example: admin/password)
        if ("admin".equals(username) && "password".equals(password)) {
            // Create a session and set the username attribute
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // Redirect to the home page after successful login
            response.sendRedirect("jsp/bankHome.jsp");
        } else {
            // Redirect back to the login page with an error message
            response.sendRedirect("jsp/login.jsp?error=invalid");
        }
    }
}
