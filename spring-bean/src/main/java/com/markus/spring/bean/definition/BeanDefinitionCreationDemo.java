package com.markus.spring.bean.definition;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author: markus
 * @date: 2022/3/11 11:37 下午
 * @Description: 通过BeanDefinitionBuilder和AbstractBeanDefinition派生类两种方式定义BeanDefinition
 * @Blog: http://markuszhang.com/
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.refresh();

        // 1. 通过BeanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("age",23)
                .addPropertyValue("name","Markus");
        // 获取Bean实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition并非Bean终态，可以自定义修改
        applicationContext.registerBeanDefinition("user1",beanDefinition);

        // 2. 通过AbstractBeanDefinition以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置Bean类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过MutablePropertyValues批量操作属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues
                .add("age",23)
                .add("name","Markus");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        applicationContext.registerBeanDefinition("user2",genericBeanDefinition);

        Map<String,User> users = applicationContext.getBeansOfType(User.class);
        System.out.println(users);
        applicationContext.close();
    }
}
