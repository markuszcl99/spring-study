package com.markus.spring.aop.feature.advisor;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import org.springframework.aop.IntroductionInfo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/6 7:52 PM
 * @Description: Introduction 与 Advisor连接器 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class IntroductionAdvisorDemo {
    public static void main(String[] args) {
        EchoService echoService = new DefaultEchoService();

        ProxyFactory proxyFactory = new ProxyFactory(echoService);
        DefaultIntroductionAdvisor introductionAdvisor = new DefaultIntroductionAdvisor(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("before ...");
            }
        }, new IntroductionInfo() {
            @Override
            public Class<?>[] getInterfaces() {
                return new Class[]{EchoService.class};// 在这里指定匹配类
            }
        });
        proxyFactory.addAdvisor(introductionAdvisor);

        EchoService proxy = (EchoService) proxyFactory.getProxy();
        proxy.echo("Hello World!");
    }
}
