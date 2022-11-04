package com.markus.aop.overview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: markus
 * @date: 2022/11/1 10:44 PM
 * @Description: jdk动态代理示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class JdkDynamicProxyDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    EchoService echoService = new ProxyEchoService(new DefaultEchoService());
                    return echoService.echo((String) args[0]);
                }
                return null;
            }
        });

        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello World!");
    }
}
