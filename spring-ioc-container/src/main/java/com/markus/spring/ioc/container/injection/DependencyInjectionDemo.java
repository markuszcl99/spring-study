package com.markus.spring.ioc.container.injection;

import com.markus.spring.ioc.container.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/9 10:22 下午
 * @Description: 依赖注入练习
 * @Blog: http://markuszhang.com/
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection.xml");

        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        // 依赖来源一：业务自定义Bean
//        System.out.println("通过名称注入（业务自定义Bean）："+userRepository.getUsers());

        // 依赖来源二：内建依赖
        System.out.println("通过类型注入（内建依赖）："+userRepository.getBeanFactory());

        // 依赖来源三：容器内建Bean
        System.out.println("通过类型注入（内建Bean）："+userRepository.getEnvironment());

        // 延迟注入
        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
        System.out.println("延迟注入："+objectFactory.getObject());

        // 手动创建BeanFactory == 注入的BeanFactory 吗？
        System.out.println(beanFactory == userRepository.getBeanFactory());
        // 手动创建BeanFactory == 注入的ApplicationContext 吗？
        System.out.println(beanFactory == objectFactory.getObject());

    }
}
