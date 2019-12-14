package com.testproj.sportapp.web;

import static org.slf4j.LoggerFactory.getLogger;

import com.testproj.sportapp.LoggedUser;
import com.testproj.sportapp.LoggerWrapper;
import com.testproj.sportapp.model.UserMeal;
import com.testproj.sportapp.repository.UserMealRepository;
import com.testproj.sportapp.repository.mock.InMemoryUserMealRepositoryImpl;
import com.testproj.sportapp.util.UserMealsUtil;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MealServlet extends HttpServlet {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MealServlet.class);

    private UserMealRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryUserMealRepositoryImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        UserMeal userMeal = new UserMeal(id.isEmpty() ? null : Integer.valueOf(id),
            LocalDateTime.parse(request.getParameter("dateTime")),
            request.getParameter("description"),
            Integer.valueOf(request.getParameter("calories")));
        LOG.info(userMeal.isNew() ? "Create {}" : "Update {}", userMeal);
        repository.save(userMeal, LoggedUser.id());
        response.sendRedirect("meals");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            LOG.info("getAll");
            request.setAttribute("mealList",
                UserMealsUtil.getWithExceeded(repository.getAll(LoggedUser.id()), 2000));
            request.getRequestDispatcher("/mealList.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            int id = getId(request);
            LOG.info("Delete {}", id);
            repository.delete(id, LoggedUser.id());
            response.sendRedirect("meals");
        } else {
            final UserMeal meal = action.equals("create") ?
                new UserMeal(LocalDateTime.now(), "", 1000) :
                repository.get(getId(request), LoggedUser.id());
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("mealEdit.jsp").forward(request, response);
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
