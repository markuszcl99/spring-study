package com.markus.aop;

import com.markus.aop.overview.ProxyEchoService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: markus
 * @date: 2022/10/12 12:18 AM
 * @Description: 动态代理示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DynamicProxyClient {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    ProxyEchoService proxyEchoService = new ProxyEchoService(new DefaultEchoService());
                    return proxyEchoService.echo((String) args[0]);
                }
                return null;
            }
        });
        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello World AOP!");
    }
}
