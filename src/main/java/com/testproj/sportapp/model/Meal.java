package com.testproj.sportapp.model;

import java.time.LocalDateTime;

/**
 * Meal for User
 *
 */
public class Meal {

    private Integer id;

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private  boolean excess;

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description , calories);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int calories) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public boolean isExcess() {
        return excess;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getCalories() {
        return calories;
    }



    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "UserMeal{" +
            "id=" + id +
            ", dateTime=" + dateTime +
            ", description='" + description + '\'' +
            ", calories=" + calories +
            '}';
    }
}