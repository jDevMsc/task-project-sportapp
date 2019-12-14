package com.testproj.sportapp.repository;

import com.testproj.sportapp.model.UserMeal;
import java.time.LocalDateTime;
import java.util.Collection;

public interface UserMealRepository {
    UserMeal save(UserMeal userMeal);

    void delete(int id);

    UserMeal get(int id);

    Collection<UserMeal> getAll();
}