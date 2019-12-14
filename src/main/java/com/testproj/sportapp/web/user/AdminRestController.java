package com.testproj.sportapp.web.user;


import static org.slf4j.LoggerFactory.getLogger;

import com.testproj.sportapp.service.UserService;
import com.testproj.sportapp.model.User;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class AdminRestController extends AbstractUserController {

    public Collection<User> getAll() {
        return super.getAll();
    }

    public User get(int id) {
        return super.get(id);
    }

    public User create(User user) {
        return super.create(user);
    }

    public void delete(int id) {
        super.delete(id);
    }

    public void update(User user, int id) {
        super.update(user, id);
    }

    public User getByMail(String email) {
        return super.getByMail(email);
    }
}