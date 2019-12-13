package com.testproj.sportapp.util;

import com.testproj.sportapp.model.UserMeal;
import com.testproj.sportapp.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create list for client
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = getFilteredMealWithExceededByCycle(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        for (UserMealWithExcess userMealWithExcess : mealsTo) {
            System.out.println(userMealWithExcess);
        }


    }


    public static List<UserMealWithExcess> getFilteredMealWithExceededByCycle(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumPerDate = new HashMap<>();
        //take all sumCalories for everyday
        for(UserMeal meal : mealList) {
            LocalDate mealDate = meal.getDateTime().toLocalDate();
            caloriesSumPerDate.put(mealDate , caloriesSumPerDate.getOrDefault(mealDate, 0) + meal.getCalories());
        }

        List<UserMealWithExcess> mealExceeded = new ArrayList<>();
        for(UserMeal meal : mealList) {
            LocalDateTime dateTime = meal.getDateTime();
            if(TimeUtil.isBetweenInclusive(dateTime.toLocalTime(), startTime, endTime)) {
                mealExceeded.add(new UserMealWithExcess(dateTime, meal.getDescription(), meal.getCalories(),
                    caloriesSumPerDate.get(dateTime.toLocalDate()) > caloriesPerDay));
            }

        }
        return mealExceeded;
    }
}
