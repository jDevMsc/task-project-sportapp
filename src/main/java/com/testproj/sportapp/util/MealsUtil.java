package com.testproj.sportapp.util;

import com.testproj.sportapp.model.Meal;
import com.testproj.sportapp.to.UserMealWithExceed;

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
public class MealsUtil {
    public static int DEFAULT_CAL = 2000;
    public static List<Meal> MEAL_LIST = Arrays
        .asList(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 510));

    public static void main(String[] args) {

    }


    public static List<UserMealWithExceed> getFilteredWithExceeded(List<Meal> mealList,
        int caloriesPerDay) {
        return getFilteredWithExceededByCycle(mealList, LocalTime.MIN, LocalTime.MAX,
            caloriesPerDay);
    }



    public static List<UserMealWithExceed> getFilteredWithExceededByCycle(
        List<Meal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumPerDate = new HashMap<>();
        //take all sumCalories for everyday
        for (Meal meal : mealList) {
            LocalDate mealDate = meal.getDateTime().toLocalDate();
            caloriesSumPerDate
                .put(mealDate, caloriesSumPerDate.getOrDefault(mealDate, 0) + meal.getCalories());
        }

        List<UserMealWithExceed> mealExceeded = new ArrayList<>();
        for (Meal meal : mealList) {
            LocalDateTime dateTime = meal.getDateTime();
            if (TimeUtil.isBetweenInclusive(dateTime.toLocalTime(), startTime, endTime)) {
                mealExceeded
                    .add(new UserMealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(),
                        caloriesSumPerDate.get(dateTime.toLocalDate()) > caloriesPerDay));
            }

        }
        return mealExceeded;
    }

    public static UserMealWithExceed createWithExceeded(Meal um, boolean exceeded) {
        return new UserMealWithExceed(um.getDateTime(), um.getDescription(), um.getCalories(), exceeded);
    }


}
