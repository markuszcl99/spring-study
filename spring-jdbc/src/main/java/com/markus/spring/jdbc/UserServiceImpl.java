package com.markus.spring.jdbc;

import com.markus.spring.jdbc.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * @author: markus
 * @date: 2023/2/22 9:50 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;

    /**
     * 设置数据源
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update(
                "insert into user(name,age) values (?,?)",
                new Object[]{
                        user.getName(), user.getAge()
                },
                new int[]{Types.VARBINARY, Types.INTEGER});
    }

    @Override
    public List<User> getUsers() {
        List<User> list = jdbcTemplate.query("select * from user", new UserRowMapper());
        return list;
    }
}
