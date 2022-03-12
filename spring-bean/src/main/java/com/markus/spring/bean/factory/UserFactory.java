package com.markus.spring.bean.factory;

import com.markus.spring.ioc.container.domain.User;

/**
 * 工厂类
 * {@link User}
 */
public interface UserFactory {
    default User createUser(){
        return User.createUser();
    }
}
