package com.testproj.sportapp.util;

import com.testproj.sportapp.model.UserMeal;
import com.testproj.sportapp.model.UserMealWithExceed;

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

    public static List<UserMeal> MEAL_LIST = Arrays
        .asList(new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
            new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
            new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
            new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
            new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
            new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 510));

    public static void main(String[] args) {

        List<UserMealWithExceed> mealsTo = getFilteredWithExceededByCycle(MEAL_LIST,
            LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        for (UserMealWithExceed userMealWithExceed : mealsTo) {
            System.out.println(userMealWithExceed);
        }
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList,
        int caloriesPerDay) {
        return getFilteredWithExceededByCycle(mealList, LocalTime.MIN, LocalTime.MAX,
            caloriesPerDay);
    }


    public static List<UserMealWithExceed> getFilteredWithExceededByCycle(
        List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumPerDate = new HashMap<>();
        //take all sumCalories for everyday
        for (UserMeal meal : mealList) {
            LocalDate mealDate = meal.getDateTime().toLocalDate();
            caloriesSumPerDate
                .put(mealDate, caloriesSumPerDate.getOrDefault(mealDate, 0) + meal.getCalories());
        }

        List<UserMealWithExceed> mealExceeded = new ArrayList<>();
        for (UserMeal meal : mealList) {
            LocalDateTime dateTime = meal.getDateTime();
            if (TimeUtil.isBetweenInclusive(dateTime.toLocalTime(), startTime, endTime)) {
                mealExceeded
                    .add(new UserMealWithExceed(dateTime, meal.getDescription(), meal.getCalories(),
                        caloriesSumPerDate.get(dateTime.toLocalDate()) > caloriesPerDay));
            }

        }
        return mealExceeded;
    }

    public static UserMealWithExceed createWithExceeded(UserMeal um, boolean exceeded) {
        return new UserMealWithExceed(um.getDateTime(), um.getDescription(), um.getCalories(), exceeded);
    }


}
