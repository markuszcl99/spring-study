package com.markus.spring.jdbc;

import com.markus.spring.jdbc.domain.User;

import java.util.List;

/**
 * @author: markus
 * @date: 2023/2/22 9:49 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface UserService {
    public void save(User user);

    public List<User> getUsers();
}
