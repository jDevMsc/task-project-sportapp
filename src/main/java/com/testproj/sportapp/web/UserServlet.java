package com.testproj.sportapp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(UserServlet.class);

    protected void doPost(HttpServletRequest request,HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        LOG.debug("forward to userList");
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }
}
