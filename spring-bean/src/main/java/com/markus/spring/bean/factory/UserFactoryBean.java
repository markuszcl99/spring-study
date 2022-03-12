package com.markus.spring.bean.factory;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: markus
 * @date: 2022/3/12 10:06 下午
 * @Description:
 * @Blog: http://markuszhang.com/
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
