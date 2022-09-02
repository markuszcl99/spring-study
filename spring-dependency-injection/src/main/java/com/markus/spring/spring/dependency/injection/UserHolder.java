package com.markus.spring.spring.dependency.injection;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import java.util.Collection;

/**
 * @author: markus
 * @date: 2022/3/19 11:27 下午
 * @Description: 管理User对象的Bean
 * @Blog: http://markuszhang.com/
 */
public class UserHolder implements BeanFactoryAware {
    private User user;

    private BeanFactory beanFactory;

    private Collection<User> users;

    public UserHolder(){

    }

    public UserHolder(User user){
        this.user = user;
    }

    public UserHolder(User user, Collection<User> users) {
        this.user = user;
        this.users = users;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", users=" + users +
                '}';
    }
}
