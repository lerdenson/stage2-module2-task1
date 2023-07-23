package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        User user = new User(firstName, lastName);
        Warehouse.getInstance().addUser(user);

        request.setAttribute("user", user);

        try {
            response.sendRedirect("/add");
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("jsp/add.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.getLocalizedMessage();
        }
    }
}
