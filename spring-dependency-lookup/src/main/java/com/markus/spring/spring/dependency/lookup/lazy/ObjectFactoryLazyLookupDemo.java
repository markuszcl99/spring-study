package com.markus.spring.spring.dependency.lookup.lazy;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author: markus
 * @date: 2022/3/18 9:56 下午
 * @Description: ObjectFactory 延迟查找 示例
 * @Blog: http://markuszhang.com/
 */
public class ObjectFactoryLazyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectFactoryLazyLookupDemo.class);
        applicationContext.refresh();

        ObjectFactory<User> objectFactory = (ObjectFactory<User>) applicationContext.getBean("objectFactory");
        System.out.println("开始调用...");
        User user = objectFactory.getObject();
        System.out.println(user);
        System.out.println("调用结束...");

        applicationContext.close();
    }

    @Bean
    @Lazy
    public User user(){
        return User.createUser();
    }

    @Bean
    public ObjectFactoryCreatingFactoryBean objectFactory(){
        ObjectFactoryCreatingFactoryBean objectFactory = new ObjectFactoryCreatingFactoryBean();
        objectFactory.setTargetBeanName("user");
        return objectFactory;
    }
}
