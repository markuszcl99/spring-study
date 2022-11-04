package com.markus.aop.overview;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/4 10:25 PM
 * @Description: 后置拦截器
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface AfterReturningInterceptor {
    /**
     * 后置执行
     *
     * @param proxy
     * @param method
     * @param args
     * @param returnValue
     * @return
     */
    public Object invoke(Object proxy, Method method, Object[] args, Object returnValue);
}
