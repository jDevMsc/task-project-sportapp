package com.testproj.sportapp.repository;

import com.testproj.sportapp.model.UserMeal;
import java.time.LocalDateTime;
import java.util.Collection;

public interface UserMealRepository {

    //update also
    UserMeal save(UserMeal userMeal, int userId);

    boolean delete(int id, int userId);

    UserMeal get(int id, int userId);

    Collection<UserMeal> getAll(int userId);

    Collection<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);
}
