package com.testproj.temp.repository.mock;

import com.testproj.temp.model.User;
import com.testproj.temp.repository.UserRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MockUserRepository implements UserRepository {

    private static final Logger LOG = LoggerFactory.getLogger(MockUserRepository.class);

    @Override
    public User save(User user) {
        LOG.info("Save :" + user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Delete :" + id);
        return true;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
