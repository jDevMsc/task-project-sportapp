package com.testproj.temp;

import com.testproj.temp.repository.mock.MockUserRepository;
import com.testproj.temp.web.user.UserRestController;
import java.util.Arrays;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        context.close();
    }

}
