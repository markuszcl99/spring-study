package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.aspect.AspectJAnnotationConfigForSource;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: markus
 * @date: 2022/11/12 3:34 PM
 * @Description: AopProxyUtils工具类演示 示例
 * {@link AopProxyUtils}
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAspectJAutoProxy
public class AopProxyUtilsDemo {
    /**
     * 调试查看AopProxyUtils工具类提供的工具接口
     * 1. AopProxyUtils#getSingletonTarget 从实例中获取目标单例对象
     * 2. AopProxyUtils#ultimateTargetClass 从实例中获取最终目标类
     * 3. AopProxyUtils#completeProxiedInterfaces 获取AdvisorSupport中所有被代理的接口
     * 4. AopProxyUtils#proxiedUserInterfaces 从代理对象中获取用户代理接口(业务接口，非SpringProxy、Advise、DecoratingProxy接口)
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AopProxyUtilsDemo.class, AspectJAnnotationConfigForSource.class);
        applicationContext.refresh();

        EchoService echoService = applicationContext.getBean(EchoService.class);
        echoService.echo("Hello World");

        applicationContext.close();
    }

    @Bean
    public EchoService echoService() {
        return new DefaultEchoService();
    }
}
