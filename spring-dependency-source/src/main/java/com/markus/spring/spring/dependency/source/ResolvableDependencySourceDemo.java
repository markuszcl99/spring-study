package com.markus.spring.spring.dependency.source;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author: markus
 * @date: 2022/3/26 12:06 下午
 * @Description: 非Spring管理对象作为依赖来源 示例
 * @Blog: http://markuszhang.com/
 */
public class ResolvableDependencySourceDemo {
    @Autowired
    private String helloWorld;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                beanFactory.registerResolvableDependency(String.class,"Hello Spring!");
            }
        });
        applicationContext.refresh();

        ResolvableDependencySourceDemo demo = applicationContext.getBean(ResolvableDependencySourceDemo.class);
        System.out.println(demo.helloWorld);

        Resource

        applicationContext.close();

    }
}
