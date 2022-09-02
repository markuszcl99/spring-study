package com.markus.spring.spring.bean.lifecycle.merge;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @author: markus
 * @date: 2022/3/31 10:56 下午
 * @Description: Spring BeanDefinition合并阶段 示例
 * @Blog: http://markuszhang.com/
 */
public class MergeBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        String resourcePath = "META-INF/dependency-lookup.xml";

        Resource resource = new ClassPathResource(resourcePath);
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        int count = beanDefinitionReader.loadBeanDefinitions(encodedResource);

        System.out.println("Bean Count is = " + count);
        User user = beanFactory.getBean("user",User.class);
        System.out.println(user);

        user = beanFactory.getBean("superUser",User.class);
        System.out.println(user);
    }
}
