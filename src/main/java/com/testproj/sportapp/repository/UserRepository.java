package com.testproj.sportapp.repository;

import com.testproj.sportapp.model.User;
import java.util.Collection;

public interface UserRepository {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    Collection<User> getAll();

}
