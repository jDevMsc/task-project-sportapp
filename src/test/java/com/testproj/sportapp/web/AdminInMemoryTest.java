package com.testproj.sportapp.web;

import static com.testproj.sportapp.UserTestData.ADMIN;
import static com.testproj.sportapp.UserTestData.USER;

import com.testproj.sportapp.UserTestData;
import com.testproj.sportapp.model.User;
import com.testproj.sportapp.repository.UserRepository;
import com.testproj.sportapp.util.exception.NotFoundException;
import com.testproj.sportapp.web.user.AdminRestController;
import java.util.Arrays;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminInMemoryTest {
    private static ConfigurableApplicationContext appCtx;
    private static AdminRestController controller;

    @BeforeClass
    public static void beforeClass() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml","spring/mock.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        controller = appCtx.getBean(AdminRestController.class);
    }

    @Before
    public void setUp() throws Exception {
        UserRepository repository = appCtx.getBean(UserRepository.class);
        repository.save(USER);
        repository.save(ADMIN);
    }

    @AfterClass
    public static void afterClass() {
        appCtx.close();
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