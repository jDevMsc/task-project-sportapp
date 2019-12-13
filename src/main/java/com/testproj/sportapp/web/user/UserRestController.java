package com.testproj.sportapp.web.user;


import static org.slf4j.LoggerFactory.getLogger;

import com.testproj.sportapp.service.UserService;
import com.testproj.sportapp.LoggedUser;
import com.testproj.sportapp.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserRestController {
    private static final Logger LOG = getLogger(UserRestController.class);

    @Autowired
    private UserService service;

    public User get() {
        int id = LoggedUser.id();
        LOG.info("get meal {} for User {}", id);
        return  service.get(id);
    }

    public void delete() {
        int id = LoggedUser.id();
        LOG.info("get meal {} for User {}", id);
        service.delete(id);
    }

    public void update(User user) {
        int id = LoggedUser.id();
        LOG.info("update");
        service.update(user);
    }


}
