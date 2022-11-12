package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/12 4:22 PM
 * @Description: AopContext-上下文辅助类工具类 演示示例
 * {@link AopContext}
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AopContextDemo {
    /**
     * 调试AopContext工具类的方法
     * AopContext内部是基于ThreadLocal实现(NamedThreadLocal)，只能在当前线程里才能获取到相应的代理类，否则获取不到。
     * 并且还需要设置暴露代理的配置。ProxyConfig#exposeProxy 设置为true
     */
    public static void main(String[] args) {
        EchoService echoService = new DefaultEchoService();

        ProxyFactory proxyFactory = new ProxyFactory(echoService);
        proxyFactory.setExposeProxy(true);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())
                        && args.length == 1
                        && args[0].getClass() == String.class) {
                    Object proxy = AopContext.currentProxy();
                    System.out.printf("current proxy object is %s\n", proxy);
                }
            }
        });

        EchoService proxy = (EchoService) proxyFactory.getProxy();
        proxy.echo("Hello World!");
    }
}
