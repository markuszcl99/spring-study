package com.markus.spring.spring.bean.lifecycle.config;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @author: markus
 * @date: 2022/3/29 11:31 下午
 * @Description: spring bean 元信息配置阶段：面向资源(Properties)配置 示例
 * @Blog: http://markuszhang.com/
 */
public class BeanMetaFacePropertiesResourceDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        String resourcePath = "META-INF/user.properties";
        Resource resource = new ClassPathResource(resourcePath);
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
        int beanDefinitionCount = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println("beanDefinitionCount = " + beanDefinitionCount);
        User user = beanFactory.getBean(User.class);
        System.out.println(user);


    }
}
