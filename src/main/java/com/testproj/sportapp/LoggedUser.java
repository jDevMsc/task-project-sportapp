package com.testproj.sportapp;

import com.testproj.sportapp.model.Role;
import java.util.Set;

public class LoggedUser {
    protected int id = 0;
    protected Set<Role> roles;
    protected boolean enabled;

    private static LoggedUser LOGGED_USER = new LoggedUser();

    public static LoggedUser get() {
        return LOGGED_USER;
    }

    public static int id() {
        return get().id;
    }

    public Set<Role> getAuthorities() {
        return roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getId() {
        return id;
    }

    public static int getCaloriesPerDay() {
        return 2000;
    }
}
