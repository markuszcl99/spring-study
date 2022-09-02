package com.markus.spring.spring.bean.lifecycle.parse;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author: markus
 * @date: 2022/4/17 5:12 下午
 * @Description: Spring Bean生命周期 BeanDefinition解析-BeanDefinitionReader 示例
 * @Blog: http://markuszhang.com/
 */
public class BeanDefinitionReaderDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        String location = "classpath:/META-INF/dependency-lookup.xml";
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(location);

        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }
}
