package com.markus.spring.spring.bean.lifecycle.merge;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author: markus
 * @date: 2022/3/31 10:56 下午
 * @Description: Spring BeanDefinition合并阶段 示例
 * @Blog: http://markuszhang.com/
 */
public class MergeBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String resourcePath = "META-INF/dependency-lookup.xml";
    }
}
