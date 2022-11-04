package com.markus.aop.overview;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/1 10:50 PM
 * @Description: Cglib动态代理示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class CglibDynamicProxyDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        // 指定super class = DefaultEchoService.class
        Class<?> superClass = DefaultEchoService.class;
        enhancer.setSuperclass(superClass);
        // 指定拦截接口
        enhancer.setInterfaces(new Class[]{EchoService.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object source, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                long startTime = System.currentTimeMillis();
                // Source -> CGLIB子类
                // 目标类 -> DefaultEchoService
//                Object result = methodProxy.invoke(source, args);
                Object result = methodProxy.invokeSuper(source, args);
                long constTime = System.currentTimeMillis() - startTime;
                System.out.println("[GCLIB 字节码提升] echo 方法执行的实现: " + constTime + " ms.");
                return result;
            }
        });

        // 创建代理对象
        EchoService echoService = (EchoService) enhancer.create();
        echoService.echo("Hello World!");
    }
}
