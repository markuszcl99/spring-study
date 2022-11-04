package com.markus.aop.overview;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/4 10:23 PM
 * @Description: 最终执行
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface FinalizeInterceptor {
    /**
     * 最终执行
     *
     * @param proxy
     * @param method
     * @param args
     * @param retValue
     * @return
     */
    public Object finalize(Object proxy, Method method, Object[] args, Object retValue);
}
