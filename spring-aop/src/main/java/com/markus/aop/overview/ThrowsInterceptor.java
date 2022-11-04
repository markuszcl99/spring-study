package com.markus.aop.overview;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/4 10:25 PM
 * @Description: 异常拦截器
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface ThrowsInterceptor {
    /**
     * 异常执行
     *
     * @param proxy
     * @param method
     * @param args
     * @param exception
     * @return
     */
    public Object invoke(Object proxy, Method method, Object[] args, Throwable exception);
}
