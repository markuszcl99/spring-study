package com.markus.spring.spring.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/20 2:28 下午
 * @Description: 通过接口回调 实现依赖注入 示例
 * @Blog: http://markuszhang.com/
 */
public class AwareDependencyInjectDemo implements BeanFactoryAware, ApplicationContextAware {

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AwareDependencyInjectDemo.class);

        applicationContext.refresh();
        AwareDependencyInjectDemo demo = applicationContext.getBean(AwareDependencyInjectDemo.class);
        System.out.println(demo.beanFactory == applicationContext.getBeanFactory());
        System.out.println(demo.applicationContext == applicationContext);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
