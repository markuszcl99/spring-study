package com.markus.spring.aop.feature.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/5 12:30 PM
 * @Description: EchoService拦截器
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class EchoServiceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        System.out.printf("proxy target class is %s, target method is %s \n", method.getDeclaringClass(), method);
        Object result = invocation.proceed();
        return result;
    }
}
