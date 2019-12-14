package com.testproj.sportapp.web;

import com.testproj.sportapp.matcher.ModelMatcher;
import com.testproj.sportapp.model.UserMeal;

public class MealTestData {

    public static final ModelMatcher<UserMeal, String> MATCHER = new ModelMatcher<>(UserMeal::toString);

}