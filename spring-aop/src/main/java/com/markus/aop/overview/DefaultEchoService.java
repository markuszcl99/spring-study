package com.markus.aop.overview;

import com.markus.aop.overview.annotation.EchoInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/1 10:38 PM
 * @Description: 默认实现
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DefaultEchoService implements EchoService, InvocationHandler {
    @Override
    public String echo(String message) {
        String result = "[echo] " + message;
        System.out.println(result);
        return result;
    }

    @Override
    public String echoWithException(String message) throws NullPointerException {
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(1111);
        return null;
    }
}
