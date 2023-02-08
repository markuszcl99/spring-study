package com.markus.spring.configuration;


import com.markus.spring.bean.User;
import org.springframework.context.annotation.Bean;

/**
 * @author: markus
 * @date: 2023/2/5 10:46 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class BeanConfiguration {

    @Bean
    public User user() {
        return new User("markus", 24);
    }
}
