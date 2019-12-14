package com.testproj.sportapp.repository;

import com.testproj.sportapp.model.UserMeal;
import java.time.LocalDateTime;
import java.util.Collection;

public interface UserMealRepository {
    // null if updated meal do not belong to userId
    UserMeal save(UserMeal userMeal, int userId);

    // false if meal do not belong to userId
    boolean delete(int id, int userId);

    // null if meal do not belong to userId
    UserMeal get(int id, int userId);

    // ORDERED DATE, TIME
    Collection<UserMeal> getAll(int userId);

    Collection<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);
}