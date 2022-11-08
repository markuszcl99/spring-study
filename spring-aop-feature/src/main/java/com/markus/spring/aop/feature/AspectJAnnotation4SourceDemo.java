package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.aspect.AspectJAnnotationConfigForSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: markus
 * @date: 2022/11/7 11:49 PM
 * @Description: 源码调试 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAspectJAutoProxy
public class AspectJAnnotation4SourceDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AspectJAnnotation4SourceDemo.class, AspectJAnnotationConfigForSource.class);
        applicationContext.refresh();

        EchoService echoService = applicationContext.getBean(EchoService.class);
        echoService.echo("Hello World");

        applicationContext.close();
    }

    @Bean
    public EchoService echoService() {
        EchoService echoService = new DefaultEchoService();
        return echoService;
    }
}
