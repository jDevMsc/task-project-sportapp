package com.testproj.sportapp.model;

import java.time.LocalDateTime;

public class MealTo {

    private final Integer id;

    private final LocalDateTime dateTime;

    private final String description;

    private final boolean excess;

    private final int calories;

    public MealTo(LocalDateTime dateTime, String description, boolean excess, int calories) {
        this(null, dateTime, description, excess, calories);
    }


    public MealTo(Integer id, LocalDateTime dateTime, String description, boolean excess,
        int calories) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.excess = excess;
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public boolean isExcess() {
        return excess;
    }

    @Override
    public String toString() {
        return "MealTo{" +
            "id=" + id +
            ", dateTime=" + dateTime +
            ", description='" + description + '\'' +
            ", excess=" + excess +
            '}';
    }
}