package com.markus.spring.spring.bean.lifecycle.other.bean;

/**
 * @author: markus
 * @date: 2022/5/6 9:44 上午
 * @Description: LifeCycleBean 示例
 * @Blog: http://markuszhang.com/
 */
public class LifeCycleBean {
    private Long id;
    private String name;
    private String address;

    public LifeCycleBean() {
    }

    public LifeCycleBean(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    @Override
    public String toString() {
        return "LifeCycleBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
