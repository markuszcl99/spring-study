package com.markus.spring.aop.feature.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ProxyMethodInvocation;

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
        System.out.printf("Joinpoint#getStaticPart is %s\n", invocation.getStaticPart());
        System.out.printf("Joinpoint#getThis is %s\n", invocation.getThis());
        /*这里我知道被拦截方法的参数只有一个*/
        System.out.printf("Invocation#getArguments is %s\n", invocation.getArguments()[0]);
        /*这里我想改变方法的参数*/
        ProxyMethodInvocation methodInvocation = (ProxyMethodInvocation) invocation;
        methodInvocation.setArguments("update info Hello World!");
        Object result = invocation.proceed();
        return result;
    }
}
