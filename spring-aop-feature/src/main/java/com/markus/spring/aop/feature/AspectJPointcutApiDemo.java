package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.interceptor.EchoServiceMethodInterceptor;
import com.markus.spring.aop.feature.pointcut.EchoServiceEchoMethodPointcut;
import com.markus.spring.aop.feature.pointcut.EchoServicePointcut;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/5 3:47 PM
 * @Description: Aspect API 实现Pointcut
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AspectJPointcutApiDemo {
    public static void main(String[] args) {

        EchoServiceEchoMethodPointcut echoServiceEchoMethodPointcut = EchoServiceEchoMethodPointcut.INSTANCE;

        // 采用组合实现
        ComposablePointcut composablePointcut = new ComposablePointcut();
        composablePointcut.intersection(echoServiceEchoMethodPointcut.getClassFilter());
        composablePointcut.intersection(echoServiceEchoMethodPointcut.getMethodMatcher());

        // 适配advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(composablePointcut, new EchoServiceMethodInterceptor());

        ProxyFactory proxyFactory = new ProxyFactory(new DefaultEchoService());
//        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new EchoServicePointcut("echo", EchoService.class), new MethodBeforeAdvice() {
//            @Override
//            public void before(Method method, Object[] args, Object target) throws Throwable {
//                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
//                    System.out.println(method);
//                }
//            }
//        });
        proxyFactory.addAdvisor(advisor);

        EchoService proxy = (EchoService) proxyFactory.getProxy();
        proxy.echo("Hello World!");
    }
}
