package com.testproj.sportapp.service;

import com.testproj.sportapp.model.User;
import com.testproj.sportapp.util.exception.NotFoundException;
import java.util.List;

public interface UserService {

    public User save(User user);

    public void delete(int id) throws NotFoundException;

    public User get(int id) throws NotFoundException;

    public User getByEmail(String email) throws NotFoundException;

    public List<User> getAll();

    public void update(User user) throws NotFoundException;

}