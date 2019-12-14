package com.testproj.sportapp;

import com.testproj.sportapp.model.BaseEntity;

public class LoggedUser {
    public static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static int getCaloriesPerDay() {
        return 2000;
    }

    public static void setId(int id) {
        LoggedUser.id = id;
    }
}
