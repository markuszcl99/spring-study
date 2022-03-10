package com.markus.spring.study.dependency.lookup;

import com.markus.spring.study.dependency.annotation.Super;
import com.markus.spring.study.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author: markus
 * @date: 2022/3/8 11:04 下午
 * @Description: 依赖查找练习
 * @Blog: http://markuszhang.com/
 * @CodePath: https://github.com/markuszcl99/spring-study
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");
        // 1.根据名称查找
        //  1.1 实时查找
        lookupByName(beanFactory);
        //  1.2 延迟查找
        lookupByNameLazy(beanFactory);
        // 2.根据类型查找
        //  2.1 单个Bean对象
        lookupBeanByType(beanFactory);
        //  2.2 集合Bean对象
        lookupCollectionBeanByType(beanFactory);
        // 3.根据名称和类型查找 getBean(name,class)
        // 4.根据注解查找
        //  4.1 查找集合Bean对象
        lookupBeansByAnnotationType(beanFactory);
    }

    private static void lookupBeansByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users= (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("根据注解查找集合对象："+users);
        }
    }

    private static void lookupCollectionBeanByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("根据类型查找集合对象："+users);
        }
    }

    private static void lookupBeanByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据类型查找："+user);
    }

    private static void lookupByNameLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("根据名称延迟查找："+user);
    }

    private static void lookupByName(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("根据名称实时查找："+user);
    }
}
