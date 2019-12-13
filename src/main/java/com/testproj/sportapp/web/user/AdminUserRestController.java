package com.testproj.sportapp.web.user;


import static org.slf4j.LoggerFactory.getLogger;

import com.testproj.sportapp.service.UserService;
import com.testproj.sportapp.model.User;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class AdminUserRestController {

    private static final Logger LOG = getLogger(AdminUserRestController.class);

    private final UserService service;

    public AdminUserRestController(@Qualifier("userServiceImpl") UserService service) {
        this.service = service;
    }

    public List<User> getAll() {
        LOG.info("getAll");
        return  service.getAll();
    }

    public User get(int id) {
        LOG.info("get " + id);
        return  service.get(id);
    }

    public User create(User user) {
        LOG.info("create " + user);
        return  service.save(user);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(User user) {
        LOG.info("update  " + user);
        service.update(user);
    }

    public User getByEmail(String email) {
        LOG.info("getByEmail " + email);
        return  service.getByEmail(email);
    }
}
