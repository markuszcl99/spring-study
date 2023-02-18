package com.markus.spring.configuration;

import com.markus.spring.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @author: markus
 * @date: 2023/2/11 4:49 PM
 * @Description: 相同类型多个Bean配置
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SameTypeBeanConfiguration {
    @Bean
    @Primary
    public User user1() {
        return new User("markus", 24);
    }

    @Bean
    public User user2() {
        return new User("Luna", 23);
    }
}
