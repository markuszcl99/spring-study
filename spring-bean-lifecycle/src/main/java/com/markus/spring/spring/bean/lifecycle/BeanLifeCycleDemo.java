package com.markus.spring.spring.bean.lifecycle;

import com.markus.spring.ioc.container.domain.User;
import com.markus.spring.spring.bean.lifecycle.processor.UserInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author: markus
 * @date: 2022/4/27 9:13 上午
 * @Description: Spring Bean生命周期 Demo
 * @Blog: http://markuszhang.com/
 */
public class BeanLifeCycleDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new UserInstantiationAwareBeanPostProcessor());

        String location = "classpath:/META-INF/dependency-lookup.xml";
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int beanCount = reader.loadBeanDefinitions(location);
        System.out.println("bean count is = " + beanCount);

//        Map<String, User> beansMap = beanFactory.getBeansOfType(User.class);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}
