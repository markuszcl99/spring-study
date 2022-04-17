package com.markus.spring.spring.bean.lifecycle.config;

import com.markus.spring.ioc.container.domain.SuperUser;
import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author: markus
 * @date: 2022/4/17 4:32 下午
 * @Description: Spring bean元信息配置阶段：面向API 示例
 * @Blog: http://markuszhang.com/
 */
public class BeanMetaFaceAPIDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 第一种方式：通过BeanDefinitionBuilder API来构建Bean元信息
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id",1)
                .addPropertyValue("name","markus")
                .addPropertyValue("age",20);
        beanFactory.registerBeanDefinition("user",builder.getBeanDefinition());

        User user = beanFactory.getBean(User.class);
        System.out.println(user);

        // 第二种方式：直接通过BeanDefinition构建Bean元信息
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(SuperUser.class);
        beanDefinition.setPrimary(true);// 设置为主要的，通过User.class来进行依赖查找时不会报错
        MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
        mutablePropertyValues.add("id",1)
                .add("name","markus")
                .add("age",20)
                .add("address","北京朝阳");
        beanFactory.registerBeanDefinition("superUser",beanDefinition);

        SuperUser superUser = (SuperUser) beanFactory.getBean(User.class);
        System.out.println(superUser);
    }
}
