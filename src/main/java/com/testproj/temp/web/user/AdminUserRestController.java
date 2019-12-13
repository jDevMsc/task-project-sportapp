package com.testproj.temp.web.user;


import com.testproj.temp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class AdminUserRestController {

    private final UserService service;

    public AdminUserRestController(@Qualifier("userServiceImpl") UserService service) {
        this.service = service;
    }
}
