package com.markus.spring.aop.feature.blog.domain;

import com.markus.aop.overview.annotation.EchoInterface;

/**
 * @author: markus
 * @date: 2022/12/1 10:17 PM
 * @Description: 默认实现
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EchoInterface
public class DefaultPointcutDemo implements PointcutDemo {
    @Override
    public void commonDemo(String message) {
        System.out.println("common demo content is " + message);
    }

    @Override
    @EchoInterface
    public void specialDemo(@EchoInterface String message) {
        System.out.println("special demo content is " + message);
    }

    @Override
    @EchoInterface
    public void specialReferenceDemo(ArgsDemo argsDemo) {
        System.out.println("special reference demo content is ");
    }
}
