package com.testproj.sportapp.repository.mock;

import com.testproj.sportapp.LoggerWrapper;
import com.testproj.sportapp.model.User;
import com.testproj.sportapp.repository.UserRepository;
import java.util.Collections;
import java.util.List;

public class MockUserRepositoryImpl implements UserRepository {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserRepositoryImpl.class);

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return true;
    }

    @Override
    public User save(User user) {
        LOG.info("save " + user);
        return user;
    }

    @Override
    public User get(int id) {
        LOG.info("get " + id);
        return null;
    }

    @Override
    public List<User> getAll() {
        LOG.info("getAll");
        return Collections.emptyList();
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("getByEmail " + email);
        return null;
    }
}