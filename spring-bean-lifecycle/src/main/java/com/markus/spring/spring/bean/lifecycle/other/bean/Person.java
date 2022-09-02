package com.markus.spring.spring.bean.lifecycle.other.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author: markus
 * @date: 2022/5/4 10:43 上午
 * @Description: 一个简单的Spring Bean
 * @Blog: http://markuszhang.com/
 */
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private Long id;
    private String name;
    private String address;
    private String iphone;

    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("【构造器】调用Person的构造器实例化");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", iphone=" + iphone +
                '}';
    }

    /*这是BeanFactoryAware接口方法*/
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware#setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware#setBeanName");
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean#afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】调用DisposableBean#destroy");
    }

    public void myInit(){
        System.out.println("【自定义初始化方法】调用myInit");
    }

    public void myDestroy(){
        System.out.println("【自定义销毁方法】调用myDestroy");
    }
}
