package com.markus.aop.overview;

/**
 * @author: markus
 * @date: 2022/11/12 11:14 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DefaultAopService implements AopService {
    @Override
    public void hello() {
        System.out.println("Hello AOP!");
    }
}
