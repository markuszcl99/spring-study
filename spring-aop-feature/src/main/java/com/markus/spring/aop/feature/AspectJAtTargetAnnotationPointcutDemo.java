package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.aspect.AspectAtTargetConfig;
import com.markus.spring.aop.feature.aspect.AspectAtWithConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: markus
 * @date: 2022/11/28 11:45 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectJAtTargetAnnotationPointcutDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(AspectJAtTargetAnnotationPointcutDemo.class, AspectAtTargetConfig.class);
        context.register(AspectJAtTargetAnnotationPointcutDemo.class, AspectAtWithConfig.class);
        context.refresh();

        EchoService echoService = context.getBean(EchoService.class);
        echoService.echo("Hello World!");

        context.close();
    }

    @Bean
    public EchoService echoService() {
        return new DefaultEchoService();
    }

    @Bean
    public String hello() {
        return "hello world";
    }
}
