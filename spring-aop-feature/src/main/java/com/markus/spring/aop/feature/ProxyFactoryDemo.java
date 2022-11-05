package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/5 12:46 PM
 * {@link ProxyFactory}
 * @Description: ProxyFactory 标准代理工厂API 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ProxyFactoryDemo {
    public static void main(String[] args) {
        EchoService echoService = new DefaultEchoService();
        ProxyFactory proxyFactory = new ProxyFactory(echoService);

        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    System.out.println("MethodBeforeAdvice: " + method);
                }
            }
        });
        proxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    System.out.printf("AfterReturningAdvice: %s, its returnValue is %s", method, returnValue);
                }
            }
        });
        EchoService proxy = (EchoService) proxyFactory.getProxy();
        proxy.echo("Hello World!");
    }
}
