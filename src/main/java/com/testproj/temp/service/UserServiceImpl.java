package com.testproj.temp.service;

import com.testproj.sportapp.model.User;
import com.testproj.sportapp.repository.UserRepository;
import com.testproj.sportapp.util.exception.NotFoundException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User Get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) throws NotFoundException {

    }
}
