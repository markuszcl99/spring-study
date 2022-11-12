package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/12 4:40 PM
 * @Description: AopUtils-AOP工具类 演示示例
 * {@link AopUtils}
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AopUtilsDemo {
    public static void main(String[] args) throws Throwable {
        EchoService echoService = new DefaultEchoService();

        ProxyFactory proxyFactory = new ProxyFactory(echoService);

        EchoService proxyEchoService = (EchoService) proxyFactory.getProxy();
        proxyEchoService.echo("Hello World!");

        // 使用AopUtils工具类
        boolean isAopProxy = AopUtils.isAopProxy(proxyEchoService);
        System.out.printf("proxyEchoService 是否是代理对象: %s\n", isAopProxy);

        boolean isJdkDynamicAopProxy = AopUtils.isJdkDynamicProxy(proxyEchoService);
        System.out.printf("proxy代理对象是否是JDK动态代理对象: %s\n", isJdkDynamicAopProxy);

        boolean isCglibAopProxy = AopUtils.isCglibProxy(proxyEchoService);
        System.out.printf("proxy代理对象是否是Cglib代理对象: %s\n", isCglibAopProxy);

        Class<?> targetClass = AopUtils.getTargetClass(proxyEchoService);
        System.out.println("代理的目标类型: " + targetClass);

        /*使用Java反射调用Join point(目标方法)*/
        Object targetObject = proxyFactory.getTargetSource().getTarget();
        Method method = targetClass.getMethod("echo", String.class);
        AopUtils.invokeJoinpointUsingReflection(targetObject, method, new Object[]{"Hello World!"});
    }
}
