package com.testproj.sportapp.web;

import static com.testproj.sportapp.UserTestData.ADMIN;
import static com.testproj.sportapp.UserTestData.USER;

import com.testproj.sportapp.UserTestData;
import com.testproj.sportapp.model.User;
import com.testproj.sportapp.repository.UserRepository;
import com.testproj.sportapp.util.exception.NotFoundException;
import com.testproj.sportapp.web.user.AdminRestController;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:spring/spring-app.xml","classpath:spring/mock.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringAdminInMemoryTest {

    @Autowired
    private AdminRestController controller;

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.save(USER);
        repository.save(ADMIN);
    }

    @Test
    public void testDelete() throws Exception {
        controller.delete(UserTestData.USER_ID);
        Collection<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(10);
    }
}