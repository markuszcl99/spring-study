package com.markus.spring.jdbc;

import com.markus.spring.jdbc.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: markus
 * @date: 2023/2/22 10:10 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SpringJdbcTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring-jdbc.xml");
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setName("silvia");
        user.setAge(80);
        userService.save(user);

        List<User> users = userService.getUsers();
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}
