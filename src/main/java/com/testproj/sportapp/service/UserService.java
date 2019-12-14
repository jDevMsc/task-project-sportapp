package com.testproj.sportapp.service;

import com.testproj.sportapp.model.User;
import com.testproj.sportapp.util.exception.NotFoundException;
import java.util.List;

public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user) throws NotFoundException;
}
