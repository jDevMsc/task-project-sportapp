package com.testproj.sportapp.web.user;

import com.testproj.sportapp.LoggerWrapper;
import com.testproj.sportapp.model.User;
import com.testproj.sportapp.service.UserService;
import java.util.Collection;
import java.util.List;

public abstract class AbstractUserController {
    protected final LoggerWrapper LOG = LoggerWrapper.get(getClass());

    private UserService service;

    public Collection<User> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        LOG.info("get " + id);
        return service.get(id);
    }

    public User create(User user) {
        user.setId(null);
        LOG.info("create " + user);
        return service.save(user);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(User user, int id) {
        user.setId(id);
        LOG.info("update " + user);
        service.update(user);
    }

    public User getByMail(String email) {
        LOG.info("getByEmail " + email);
        return service.getByEmail(email);
    }
}