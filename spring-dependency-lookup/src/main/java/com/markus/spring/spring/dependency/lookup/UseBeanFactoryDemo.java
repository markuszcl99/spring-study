package com.markus.spring.spring.dependency.lookup;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author: markus
 * @date: 2022/3/17 12:17 下午
 * @Description: 使用BeanFactory实现单一类型查找功能 示例
 * @Blog: http://markuszhang.com/
 */
public class UseBeanFactoryDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(UseBeanFactoryDemo.class);
        applicationContext.refresh();

        BeanFactory beanFactory = applicationContext.getBeanFactory();
        User user = (User) beanFactory.getBean("user",new Object[]{20,"markus"});
        BeanDefinition beanDefinition = applicationContext.getBeanDefinition("user");
        User user1 = (User) beanFactory.getBean("user",new Object[]{23,"markus"});
        BeanDefinition beanDefinition1 = applicationContext.getBeanDefinition("user");
        System.out.println(user);
        System.out.println(user1);

        applicationContext.close();
    }

    @Bean
    @Scope(value = "prototype")
    public User user(int age,String name){
        return User.createUser(age,name);
    }
}
