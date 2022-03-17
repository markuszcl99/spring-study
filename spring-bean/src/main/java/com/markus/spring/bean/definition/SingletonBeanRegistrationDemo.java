package com.markus.spring.bean.definition;

import com.markus.spring.bean.factory.DefaultUserFactory;
import com.markus.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/16 5:51 下午
 * @Description: 外部单体Bean注册
 * @Blog: http://markuszhang.com/
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        UserFactory userFactory = new DefaultUserFactory();
        // 第一种方式：通过ConfigurableListableBeanFactory注册
//        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
//        beanFactory.registerSingleton("userFactory", userFactory);
        // 第二种方式：通过SingletonBeanRegistry注册
        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();
        singletonBeanRegistry.registerSingleton("userFactory", userFactory);
        applicationContext.refresh();
        UserFactory userFactoryByLookup = applicationContext.getBean("userFactory", UserFactory.class);

        System.out.println("userFactory == userFactoryByLookup : " + (userFactory == userFactoryByLookup));
        applicationContext.close();

    }
}
