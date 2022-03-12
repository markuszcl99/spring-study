package com.markus.spring.bean.definition;

import com.markus.spring.bean.factory.DefaultUserFactory;
import com.markus.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: markus
 * @date: 2022/3/12 10:40 下午
 * @Description: 特殊的 Bean 实例化示例
 * @Blog: http://markuszhang.com/
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        // 配置 XML配置文件
        // 启动 Spring应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
        //通过ServiceLoader创建Bean
//        demoServiceLoader();

        // 1. 通过ServiceLoaderFactoryBean实例化Bean
        ServiceLoader<UserFactory> serviceLoader = applicationContext.getBean("userFactoryServiceLoader",ServiceLoader.class);
        displayServiceLoader(serviceLoader);

        // 2. 通过AutowireCapableBeanFactory 实例化Bean
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());

    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    public static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader){
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}
