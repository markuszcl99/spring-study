package com.markus.spring.spring.bean.lifecycle.config;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author: markus
 * @date: 2022/3/29 11:27 下午
 * @Description: spring bean 元信息配置阶段：面向资源(XML)配置 示例
 * @Blog: http://markuszhang.com/
 */
public class BeanMetaFaceXMLResourceDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String resource = "classpath:/META-INF/dependency-lookup.xml";
        int beanDefinitionCount = beanDefinitionReader.loadBeanDefinitions(resource);
        System.out.println("beanDefinitionCount = "+beanDefinitionCount);
        System.out.println(beanFactory.getBean(User.class));
    }
}
