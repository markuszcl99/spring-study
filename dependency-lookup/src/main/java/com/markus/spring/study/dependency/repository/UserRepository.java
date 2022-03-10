package com.markus.spring.study.dependency.repository;

import com.markus.spring.study.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Collection;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/3/9 10:24 下午
 * @Description: 用户操作
 * @Blog: http://markuszhang.com/
 */
public class UserRepository {
    /**
     * 注入自定义Bean
     */
    private Collection<User> users;
    /**
     * 注入内建依赖
     */
    private BeanFactory beanFactory;
    /**
     * 注入容器Bean
     */
    private Environment environment;

    /**
     * 延迟注入
     */
    private ObjectFactory<ApplicationContext> objectFactory;

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
