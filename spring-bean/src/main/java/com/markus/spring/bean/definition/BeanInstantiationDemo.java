package com.markus.spring.bean.definition;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/12 5:37 下午
 * @Description: Bean 实例化 示例
 * @Blog: http://markuszhang.com/
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");

        // 1. 通过静态方法
        User user = beanFactory.getBean("user-by-static-method",User.class);
        // 2. 通过实例方法
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method",User.class);
        // 3. 通过工厂方法
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean",User.class);

        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);
        System.out.println(user == userByInstanceMethod);
        System.out.println(user == userByFactoryBean);
    }
}
