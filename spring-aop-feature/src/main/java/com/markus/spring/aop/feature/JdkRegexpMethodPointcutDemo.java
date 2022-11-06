package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/6 2:14 PM
 * @Description: 基于JDK 正则表达式实现的切入点 演示示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class JdkRegexpMethodPointcutDemo {
    public static void main(String[] args) {

        EchoService echoService = new DefaultEchoService();

        ProxyFactory proxyFactory = new ProxyFactory(echoService);

        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        // todo jdk 正则表达式不太熟悉，后续了解
        jdkRegexpMethodPointcut.setPattern(".*echo.*");
        // Pointcut最通用的便利实现
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor(jdkRegexpMethodPointcut, new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("base jdk regexp pointcut...");
            }
        });
//        proxyFactory.addAdvisor(pointcutAdvisor);

        // Pointcut 基于Regexp的便利实现
        RegexpMethodPointcutAdvisor regexpMethodPointcutAdvisor = new RegexpMethodPointcutAdvisor();
        regexpMethodPointcutAdvisor.setPattern(".*echo.*");
        regexpMethodPointcutAdvisor.setAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("base jdk regexp pointcut and its Convenient RegexpMethodPointcutAdvisor...");
            }
        });
        proxyFactory.addAdvisor(regexpMethodPointcutAdvisor);

        EchoService proxy = (EchoService) proxyFactory.getProxy();
        proxy.echo("Hello World!");
    }
}
