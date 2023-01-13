package com.markus.spring.spring.dependency.lookup.factory;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2023/1/1 11:29 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class FactoryBeanDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/factory-bean.xml");
        User user = (User) context.getBean("user");
        System.out.println("user object "+user);
        context.close();
    }
}
