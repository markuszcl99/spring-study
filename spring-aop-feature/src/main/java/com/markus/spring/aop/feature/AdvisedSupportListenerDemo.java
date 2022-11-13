package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AdvisedSupportListener;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/13 9:36 PM
 * @Description: AdvisedSupportListener演示示例
 * {@link AdvisedSupportListener}
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AdvisedSupportListenerDemo {
    public static void main(String[] args) {
        EchoService echoService = new DefaultEchoService();

        ProxyFactory proxyFactory = new ProxyFactory(echoService);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("before...");
            }
        });

        proxyFactory.addListener(new AdvisedSupportListener() {
            @Override
            public void activated(AdvisedSupport advised) {
                System.out.println("first active...");
            }

            @Override
            public void adviceChanged(AdvisedSupport advised) {
                System.out.println("advice changed...");
            }
        });

        EchoService proxyEchoService = (EchoService) proxyFactory.getProxy();
        /*在创建完代理之后，如果再添加advice，将会调用adviceChanged*/
        proxyEchoService.echo("Hello World");
        proxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("afterReturning...");
            }
        });

        proxyEchoService.echo("second Hello World!");
    }
}
