package com.markus.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: markus
 * @date: 2022/3/12 5:53 下午
 * @Description:
 * @Blog: http://markuszhang.com/
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init(){
        System.out.println("Java注解 init(): UserFactory 初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("spring方法 afterPropertiesSet(): UserFactory 初始化中...");
    }

    public void initUserFactory(){
        System.out.println("自定义初始化方法 initUserFactory(): UserFactory 初始化中...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Java注解 preDestroy(): UserFactory 销毁中...");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("spring方法 destroy(): UserFactory 销毁中...");
    }

    public void doDestroy(){
        System.out.println("自定义方法 doDestroy(): UserFactory 销毁中...");
    }
}
