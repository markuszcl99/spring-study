package com.markus.spring.jdbc;

import com.markus.spring.jdbc.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: markus
 * @date: 2023/2/22 9:47 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User person = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"));
        return person;
    }
}
