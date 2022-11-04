package com.markus.aop.overview;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/4 10:20 PM
 * @Description: 前置执行
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface BeforeInterceptor {
    /**
     * 前置执行
     *
     * @param proxy
     * @param method
     * @param args
     */
    public Object before(Object proxy, Method method, Object[] args);
}
