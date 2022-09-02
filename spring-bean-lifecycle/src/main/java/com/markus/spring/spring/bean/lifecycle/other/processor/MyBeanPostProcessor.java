package com.markus.spring.spring.bean.lifecycle.other.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: markus
 * @date: 2022/5/4 11:09 上午
 * @Description: 自定义BeanPostProcessor
 * @Blog: http://markuszhang.com/
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("这是BeanPostProcessor的实现类构造器");
    }

    // 在属性赋值之后，在初始化方法（InitializingBean#afterPropertiesSet、自定义方法）之前进行调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return bean;
    }

    // 在初始化方法（InitializingBean#afterPropertiesSet、自定义方法）之后进行调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return bean;
    }
}
