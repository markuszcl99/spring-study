package com.markus.spring.spring.dependency.lookup.collection;

import com.markus.spring.ioc.container.annotation.Super;
import com.markus.spring.ioc.container.domain.SuperUser;
import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ResolvableType;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author: markus
 * @date: 2022/3/17 7:18 下午
 * @Description: 集合类型的依赖查找 示例
 * @Blog: http://markuszhang.com/
 */
public class ListableBeanFactoryLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ListableBeanFactoryLookupDemo.class);
        applicationContext.refresh();

        ListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        getBeanNamesForType(beanFactory);
        getBeanNamesForResolvableType(beanFactory);
        getBeansOfType(beanFactory);
        getBeanNamesForAnnotation(beanFactory);
        getBeansWithAnnotation(beanFactory);
        findAnnotationOnBean(beanFactory);

        applicationContext.close();
    }

    private static void getBeanNamesForType(ListableBeanFactory beanFactory){
        String[] beanNames = beanFactory.getBeanNamesForType(User.class);
        System.out.println("【根据Class查找Bean名称列表】");
        for (String beanName : beanNames) {
            System.out.println("\t\t"+beanName);
        }
    }

    private static void getBeanNamesForResolvableType(ListableBeanFactory beanFactory){
        ResolvableType resolvableType = ResolvableType.forType(User.class);
        String [] beanNames = beanFactory.getBeanNamesForType(resolvableType);
        System.out.println("【根据ResolvableType查找Bean名称列表】");
        for (String beanName : beanNames) {
            System.out.println("\t\t"+beanName);
        }
    }

    private static void getBeansOfType(ListableBeanFactory beanFactory){
        Map<String,User> userMap = beanFactory.getBeansOfType(User.class);
        System.out.println("【根据Class查找Bean实例】\n\t\t"+userMap);
    }

    /**
     * since spring3.0
     * @param beanFactory
     */
    private static void getBeanNamesForAnnotation(ListableBeanFactory beanFactory){
        String[] beanNamesForAnnotation = beanFactory.getBeanNamesForAnnotation(Super.class);
        System.out.println("【根据Annotation查找Bean名称列表】");
        for (String beanName : beanNamesForAnnotation) {
            System.out.println("\t\t"+beanName);
        }
    }
    private static void getBeansWithAnnotation(ListableBeanFactory beanFactory){
        Map<String,Object> beansMap = beanFactory.getBeansWithAnnotation(Super.class);
        System.out.println("【根据Annotation查找Bean实例】\n\t\t"+beansMap);
    }

    private static void findAnnotationOnBean(ListableBeanFactory beanFactory){
        Annotation annotation = beanFactory.findAnnotationOnBean("superUser",Super.class);
        System.out.println("【根据Annotation类型+bean名称查找Bean注解】\n\t\t"+annotation);
    }


    @Bean
    @Primary
    public User user(){
        return User.createUser();
    }

    @Bean
    public User user1(){
        return User.createUser(1,"Hello");
    }

    @Bean
    public SuperUser superUser(){
        return SuperUser.createSuperUser();
    }
}
