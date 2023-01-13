package com.markus.spring.spring.dependency.lookup.factory;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: markus
 * @date: 2023/1/1 11:25 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class UserFactoryBean implements FactoryBean<User> {
    private String userInfo;

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public User getObject() throws Exception {
        String[] infos = userInfo.split(",");
        Long id = Long.valueOf(infos[0]);
        String name = infos[1];
        User user = new User();
        user.setName(name);
        user.setId(id);
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
