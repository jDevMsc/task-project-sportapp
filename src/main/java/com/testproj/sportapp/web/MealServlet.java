package com.testproj.sportapp.web;

import static org.slf4j.LoggerFactory.getLogger;

import com.testproj.sportapp.util.UserMealsUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;

public class MealServlet extends HttpServlet {

    private static final Logger LOG = getLogger(MealServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        LOG.info("getAllMeals");
        request.setAttribute("mealList", UserMealsUtil.getFilteredWithExceeded(UserMealsUtil.MEAL_LIST,2000));
        request.getRequestDispatcher("mealList.jsp").forward(request, response);
    }
}
