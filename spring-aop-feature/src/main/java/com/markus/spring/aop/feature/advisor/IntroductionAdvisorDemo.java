package com.markus.spring.aop.feature.advisor;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.introduction.UsageTracked;
import com.markus.spring.aop.feature.introduction.support.DefaultUsageTracked;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.IntroductionInfo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import sun.reflect.Reflection;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/6 7:52 PM
 * @Description: Introduction 与 Advisor连接器 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class IntroductionAdvisorDemo {
    public static void main(String[] args) throws ClassNotFoundException {
//        EchoService echoService = new DefaultEchoService();
        UsageTracked usageTracked = new DefaultUsageTracked();

        ProxyFactory proxyFactory = new ProxyFactory(usageTracked);
        DefaultIntroductionAdvisor introductionAdvisor = new DefaultIntroductionAdvisor(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("before ...");
            }
        }, new IntroductionInfo() {
            @Override
            public Class<?>[] getInterfaces() {
                return new Class[]{EchoService.class, UsageTracked.class};// 在这里指定匹配类
            }
        });
        proxyFactory.addAdvisor(introductionAdvisor);

        EchoService proxy = (EchoService) proxyFactory.getProxy();
        proxy.echo("Hello World!");
        UsageTracked proxyUsageTracked = (UsageTracked) proxyFactory.getProxy();
        proxyUsageTracked.echoMethodInvokeCount();

        /*下面是isAssignableFrom的学习*/
        Class<?> clazz = Class.forName("com.markus.aop.overview.DefaultEchoService");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.printf("method.getDeclaringClass().isAssignableFrom(EchoService.class) result is %s,method method.getDeclaringClass() is %s,method is %s\n",
                    method.getDeclaringClass().isAssignableFrom(DefaultEchoService.class), method.getDeclaringClass(), method);
        }

        System.out.println(MethodBeforeAdvice.class.isAssignableFrom(AfterAdvice.class));
    }
}
