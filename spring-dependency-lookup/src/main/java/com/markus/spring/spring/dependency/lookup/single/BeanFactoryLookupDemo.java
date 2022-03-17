package com.markus.spring.spring.dependency.lookup.single;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.Order;

import java.util.Iterator;

/**
 * @author: markus
 * @date: 2022/3/17 4:07 下午
 * @Description: 单一类型的依赖查找 示例
 * @Blog: http://markuszhang.com/
 */
public class BeanFactoryLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanFactoryLookupDemo.class);
        applicationContext.refresh();

        BeanFactory beanFactory = applicationContext.getBeanFactory();
        lookupByName(beanFactory);
        lookupRealTimeByType(beanFactory);
        lookupLazyByType(beanFactory);
        lookupByNameAndType(beanFactory);

        applicationContext.close();
    }


    public static void lookupByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("【通过名称实时查找】\n\t\t"+user);
    }

    public static void lookupRealTimeByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("【通过类型实时查找】\n\t\t"+user);
    }

    public static void lookupLazyByType(BeanFactory beanFactory) {
        // 1. 通过Resolvable
        ResolvableType type = ResolvableType.forType(User.class);
        ObjectProvider<User> objectProvider = beanFactory.getBeanProvider(type);
        Iterator<User> iterator = objectProvider.orderedStream().iterator();
        System.out.println("【通过Resolvable类型延迟查找】: ");
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println("\t\t"+user);
        }
        // 2. 通过Class
        ObjectProvider<User> objectProviderByClass = beanFactory.getBeanProvider(User.class);
        Iterator<User> iteratorByClass = objectProviderByClass.orderedStream().iterator();
        System.out.println("【通过Class类型延迟查找】: ");
        while (iteratorByClass.hasNext()) {
            User user = iteratorByClass.next();
            System.out.println("\t\t"+user);
        }
    }

    public static void lookupByNameAndType(BeanFactory beanFactory){
        User user = beanFactory.getBean("user",User.class);
        System.out.println("【通过名称和类型实时查找】\n\t\t"+user);
    }

    @Bean
    @Order(2)
    @Primary
    public User user() {
        return User.createUser();
    }

    @Bean
    @Order(1)
    public User user1() {
        return User.createUser(1, "hello");
    }
}
