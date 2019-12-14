package com.testproj.sportapp.web.user;

import com.testproj.sportapp.LoggedUser;
import com.testproj.sportapp.model.User;

public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(LoggedUser.id());
    }

    public void delete() {
        super.delete(LoggedUser.id());
    }

    public void update(User user) {
        super.update(user, LoggedUser.id());
    }
}