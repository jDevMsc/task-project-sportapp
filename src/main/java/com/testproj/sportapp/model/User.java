package com.testproj.sportapp.model;

import com.testproj.sportapp.model.NamedEntity;
import com.testproj.sportapp.model.Role;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

public class User extends NamedEntity {

    private String email;

    private String password;

    private boolean enabled = true;

    private Date registered = new Date();

    private Set<Role> authorities;

    public User() {
    }

    public User(String name, String email, String password, Role role, Role... roles) {
        super(name);
        this.email = email;
        this.password = password;
        this.enabled = true;
        this.authorities = EnumSet.of(role, roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    @Override
    public String toString() {
        return "User{" +
            "email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", enabled=" + enabled +
            ", registered=" + registered +
            ", name='" + name + '\'' +
            '}';
    }
}