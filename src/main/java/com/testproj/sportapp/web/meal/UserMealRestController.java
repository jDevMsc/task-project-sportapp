package com.testproj.sportapp.web.meal;


import com.testproj.sportapp.service.UserMealServiceImpl;
import com.testproj.sportapp.LoggedUser;
import com.testproj.sportapp.model.UserMeal;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserMealRestController {

private static final Logger LOG = LoggerFactory.getLogger(UserMealRestController.class);

    @Autowired
    private UserMealServiceImpl service;

    public UserMeal get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get meal {} for User {}", id, userId);
        return  service.get(id, userId);
    }

    public void delete(int id) {
        int userId = LoggedUser.id();
        LOG.info("delete meal {} for User {}", id, userId);
        return  service.delete(id, userId);
    }

    public List<UserMeal> getAll() {
        int userId = LoggedUser.id();
        LOG.info("getAll for User {}", userId);
        return  service.getAll(userId);
    }

    public void deleteAll() {
        int userId = LoggedUser.id();
        LOG.info("deleteAll for User {}", userId);
        service.deleteAll(userId);
    }

    public void update(UserMeal meal) {
        int userId = LoggedUser.id();
        LOG.info("update  {} for User {}",meal,  userId);
        service.update(meal, userId);
    }

    public UserMeal create(UserMeal meal) {
        int userId = LoggedUser.id();
        LOG.info("create  {} for User {}",meal,  userId);
        return service.save(meal, userId);
    }

    public List<UserMeal> getBetween(LocalDate startDate, LocalDate endDate) {
        int userId = LoggedUser.id();
        LOG.info("getBetween  {} and {} for User {}",startDate, endDate, userId);
        return service.getBetween(startDate, endDate, userId);
    }

}
