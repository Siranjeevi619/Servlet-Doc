package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
//            res.sendRedirect("dashboard.jsp");
            req.getRequestDispatcher("dashboard.jsp").forward(req, res);
        } else {
            res.getWriter().println("Invalid credentials. <a href='login.html'>Try again</a>");
        }
    }
}
