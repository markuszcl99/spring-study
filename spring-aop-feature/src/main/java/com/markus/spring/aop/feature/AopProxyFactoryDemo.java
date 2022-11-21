package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/11/21 11:30 PM
 * @Description: AopProxy代理工厂创建AopProxy条件示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AopProxyFactoryDemo {
    public static void main(String[] args) {
        EchoService echoService = new DefaultEchoService();
        ProxyFactory proxyFactory = new ProxyFactory(echoService);
//        proxyFactory.setOptimize(true);
//        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setOpaque(false);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("before...");
            }
        });
        Object proxy = proxyFactory.getProxy();
        System.out.println(proxy);
        Advised advised = (Advised) proxy;
        List<Advisor> advisorList = Arrays.asList(advised.getAdvisors());
        System.out.println(advisorList);
    }
}
