package com.markus.spring.aop.feature.blog.domain;

import com.markus.aop.overview.annotation.EchoInterface;

/**
 * @author: markus
 * @date: 2022/12/1 10:32 PM
 * @Description: 参数类型
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EchoInterface
public class ArgsDemo {
    private String message;

    public ArgsDemo() {
    }

    public ArgsDemo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
