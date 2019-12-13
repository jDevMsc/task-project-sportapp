package com.testproj.sportapp.repository;

import com.testproj.sportapp.model.Meal;
import java.util.Collection;

public interface UserMealRepository {

        //update also
    Meal save(Meal meal);

    void delete(int id);

    Meal get(int id);

    Collection<Meal> getAll();
}
