package com.markus.spring.aop.feature.blog;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.blog.aspect.AspectJAnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: markus
 * @date: 2022/11/29 1:20 PM
 * @Description: AspectJ注解使用示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAspectJAutoProxy
public class AspectJAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotationDemo.class, AspectJAnnotationConfig.class);
        context.refresh();

        EchoService echoService = context.getBean(EchoService.class);
        echoService.echo("Hello World!");

        context.close();
    }

    @Bean
    public EchoService echoService() {
        return new DefaultEchoService();
    }
}
