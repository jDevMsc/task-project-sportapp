package com.testproj.sportapp.web;

import com.testproj.sportapp.LoggedUser;
import com.testproj.sportapp.LoggerWrapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServlet extends HttpServlet {
    private static final LoggerWrapper LOG = LoggerWrapper.get(UserServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.valueOf(request.getParameter("userId"));
        LoggedUser.setId(userId);
        response.sendRedirect("meals");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to userList");

//        request.getRequestDispatcher("/userList.jsp").forward(request, response);
        response.sendRedirect("userList.jsp");
    }
}