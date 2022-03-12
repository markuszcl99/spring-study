package com.markus.spring.ioc.container.domain;

import com.markus.spring.ioc.container.annotation.Super;

/**
 * @author: markus
 * @date: 2022/3/8 11:32 下午
 * @Description: 超级用户
 * @Blog: http://markuszhang.com/
 */
@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
