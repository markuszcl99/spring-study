package com.markus.spring.jdbc;

import com.markus.spring.jdbc.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: markus
 * @date: 2023/2/20 9:53 PM
 * @Description: JDBC单独使用demo，不涉及Spring
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class JDBCUseAloneDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        try (Connection connection = getConnection("jdbc:mysql://localhost:3306/spring", "root", "root")) {
            // 3. 创建执行SQL对象
            Statement statement = connection.createStatement();
            // 3.1 获取表数据
            ResultSet resultSet = statement.executeQuery("select * from user");
            // 3.2 将ResultSet映射为user数据集合
            List<User> userList = getUsers(resultSet);
            // 4 打印
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
        // 1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 创建链接对象
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    private static List<User> getUsers(ResultSet resultSet) throws SQLException {
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            User user = new User(id, name, age);
            userList.add(user);
        }
        return userList;
    }


    /**
     * 打印驱动
     */
    private static void printDrivers() {
        Enumeration<Driver> driverEnum = DriverManager.getDrivers();
        while (driverEnum.hasMoreElements()) {
            Driver driver1 = driverEnum.nextElement();
            System.out.println(driver1);
        }
    }
}
