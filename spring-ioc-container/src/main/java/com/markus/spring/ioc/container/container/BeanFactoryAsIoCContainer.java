package com.markus.spring.ioc.container.container;


import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author: markus
 * @date: 2022/3/10 10:32 下午
 * @Description: BeanFactory 作为IoC容器
 * @Blog: http://markuszhang.com/
 */
public class BeanFactoryAsIoCContainer {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        String location = "classpath:/META-INF/dependency-lookup.xml";
        int count = reader.loadBeanDefinitions(location);
        System.out.println("Bean数量："+count);
    }

}
