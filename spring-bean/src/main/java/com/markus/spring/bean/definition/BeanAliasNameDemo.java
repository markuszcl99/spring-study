package com.markus.spring.bean.definition;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/12 11:01 上午
 * @Description: 通过别名获取Bean
 * @Blog: http://markuszhang.com/
 */
public class BeanAliasNameDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        User user = (User) beanFactory.getBean("user2");
        User markusUser = (User) beanFactory.getBean("markus-user");
        System.out.println("user 是否和 markusUser相等："+ (user == markusUser));
    }
}
