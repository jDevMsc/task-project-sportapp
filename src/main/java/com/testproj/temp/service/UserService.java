package com.testproj.temp.service;

import com.testproj.temp.model.User;
import com.testproj.temp.util.exception.NotFoundException;
import java.util.List;

public interface UserService {

    public User save(User user);

    public void delete(int id) throws NotFoundException;

    public User Get(int id) throws NotFoundException;

    public User getByEmail(String email) throws NotFoundException;

    public List<User> getAll();

    public void update(User user) throws NotFoundException;

}
