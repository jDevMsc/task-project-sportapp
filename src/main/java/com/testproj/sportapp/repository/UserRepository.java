package com.testproj.sportapp.repository;

import com.testproj.sportapp.model.User;
import java.util.Collection;
import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();
}
