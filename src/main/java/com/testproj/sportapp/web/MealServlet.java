package com.testproj.sportapp.web;

import static org.slf4j.LoggerFactory.getLogger;

import com.testproj.sportapp.model.Meal;
import com.testproj.sportapp.repository.InMemoryUserMealRepository;
import com.testproj.sportapp.repository.UserMealRepository;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;

public class MealServlet extends HttpServlet {

    private static final Logger LOG = getLogger(MealServlet.class);
    private  UserMealRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryUserMealRepository();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        Meal meal = new Meal(id.isEmpty() ? null : Integer.valueOf(id),
            LocalDateTime.parse(request.getParameter("dateTime")),
            request.getParameter("description"),
            Integer.parseInt(request.getParameter("calories")));

        LOG.info(meal.isNew() ? "Create {}" : "Update {}", meal);
        repository.save(meal);
        response.sendRedirect("meals");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            LOG.info("getAllMeals");
//            request.setAttribute("mealList", UserMealsUtil.getFilteredWithExceeded(UserMealsUtil.MEAL_LIST,2000));
            request.setAttribute("mealList", repository.getAll());
            request.getRequestDispatcher("meals.jsp").forward(request, response);
        } else if(action.equals("delete")) {
            int id = getId(request);
            LOG.info("Delete {}" , id);
            repository.delete(id);
            response.sendRedirect("meals");
        } else {
            final Meal meal = action.equals("create") ? new Meal(LocalDateTime.now(),"",1000) :
                repository.get(getId(request));
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("edit.jsp").forward(request , response);
        }

    }
    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

}
