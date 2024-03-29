package com.markus.spring.ioc.container.domain;

import com.markus.spring.ioc.container.eunms.City;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

public class User implements BeanNameAware {
    private Long id;
    private Integer age;
    private String name;
    private City city;  // 枚举类型 ∈ 基础类型（标量类型）
    private City[] workCities;// 数组类型
    private List<City> lifeCities;// 集合类型
    private Resource resource;// Spring类型 ∈ 基础类型

    private transient String beanName;

    public User(){
//        System.out.println("我被初始化了...");
    }
    public User(int age,String name){
        this.age = age;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City[] getWorkCities() {
        return workCities;
    }

    public void setWorkCities(City[] workCities) {
        this.workCities = workCities;
    }

    public List<City> getLifeCities() {
        return lifeCities;
    }

    public void setLifeCities(List<City> lifeCities) {
        this.lifeCities = lifeCities;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", lifeCities=" + lifeCities +
                ", resource=" + resource +
                '}';
    }

    public static User createUser(){
        System.out.println("我被创建了...");
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

//    @PostConstruct
    public void init(){
        System.out.println("["+beanName+"] Bean 正在初始化...");
    }

//    @PreDestroy
    public void destroy(){
        System.out.println("["+beanName+"] Bean 正在销毁...");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
