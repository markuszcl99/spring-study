package com.markus.spring.spring.dependency.injection;

import com.markus.spring.ioc.container.domain.User;

/**
 * @author: markus
 * @date: 2022/3/19 11:27 下午
 * @Description: 管理User对象的Bean
 * @Blog: http://markuszhang.com/
 */
public class UserHolder {
    private User user;

    public UserHolder(){

    }

    public UserHolder(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
