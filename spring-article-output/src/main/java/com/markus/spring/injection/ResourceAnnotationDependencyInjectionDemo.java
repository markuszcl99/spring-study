package com.markus.spring.injection;

import com.markus.spring.bean.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: markus
 * @date: 2023/2/12 10:33 PM
 * @Description: @Resource注解使用
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Import({
        com.markus.spring.configuration.SameTypeBeanConfiguration.class
})
public class ResourceAnnotationDependencyInjectionDemo {

    @Resource
    private List<User> users;

    @Resource
    private User user;

    @Resource(name = "user2")
    private User userFromName;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ResourceAnnotationDependencyInjectionDemo.class);
        context.refresh();

        ResourceAnnotationDependencyInjectionDemo demo = context.getBean(ResourceAnnotationDependencyInjectionDemo.class);
        System.out.println("demo.users : " + demo.users);
        System.out.println("demo.user : " + demo.user);
        System.out.println("demo.userFromName : " + demo.userFromName);
    }
}
