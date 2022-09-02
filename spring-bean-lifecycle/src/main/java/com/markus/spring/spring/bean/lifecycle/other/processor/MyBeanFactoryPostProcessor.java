package com.markus.spring.spring.bean.lifecycle.other.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author: markus
 * @date: 2022/5/4 11:08 上午
 * @Description: 自定义 BeanFactoryPostProcessor
 * @Blog: http://markuszhang.com/
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        System.out.println("这是BeanFactoryPostProcessor实现类构造器");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryPostProcessor#postProcessBeanFactory方法");
        BeanDefinition bd = beanFactory.getBeanDefinition("person");
        bd.getPropertyValues().add("iphone", 120);
    }
}
