package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.aspect.AspectJAnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: markus
 * @date: 2022/11/4 11:45 PM
 * @Description: AspectJ 注解示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAspectJAutoProxy
public class AspectJAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotationDemo.class, AspectJAnnotationConfig.class);
//        context.scan("com.markus.spring.aop.feature.aspect");
        context.refresh();
        EchoService echoService = context.getBean(EchoService.class);
        echoService.echo("Hello World!");
        context.close();
    }

    @Bean
    public EchoService echoService() {
        EchoService echoService = new DefaultEchoService();
        return echoService;
    }
}
