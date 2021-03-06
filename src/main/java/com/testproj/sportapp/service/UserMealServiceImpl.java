package com.testproj.sportapp.service;

import com.testproj.sportapp.model.UserMeal;
import com.testproj.sportapp.repository.UserMealRepository;
import com.testproj.sportapp.util.exception.ExceptionUtil;
import java.time.LocalDateTime;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal get(int id, int userId) {
        return ExceptionUtil.check(repository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) {
        ExceptionUtil.check(repository.delete(id, userId), id);
    }

    @Override
    public Collection<UserMeal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return repository.getBetween(startDateTime, endDateTime, userId);
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public UserMeal update(UserMeal meal, int userId) {
        return ExceptionUtil.check(repository.save(meal, userId), meal.getId());
    }

    @Override
    public UserMeal save(UserMeal meal, int userId) {
        return repository.save(meal, userId);
    }
}
