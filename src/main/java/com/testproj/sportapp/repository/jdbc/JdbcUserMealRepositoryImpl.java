package com.testproj.sportapp.repository.jdbc;

import com.testproj.sportapp.model.UserMeal;
import com.testproj.sportapp.repository.UserMealRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserMealRepositoryImpl implements UserMealRepository {

    @Override
    public UserMeal save(UserMeal UserMeal, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public UserMeal get(int id, int userId) {
        return null;
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return null;
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}