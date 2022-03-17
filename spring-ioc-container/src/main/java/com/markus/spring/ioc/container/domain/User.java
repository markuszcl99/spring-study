package com.markus.spring.ioc.container.domain;

public class User {
    private Integer age;
    private String name;

    public User(){
        this.age = 18;
        this.name = "Hello";
    }
    public User(int age,String name){
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUser(){
        User user = new User();
        user.setAge(23);
        user.setName("Markus");
        return user;
    }

    public static User createUser(int age,String name){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return user;
    }
}
