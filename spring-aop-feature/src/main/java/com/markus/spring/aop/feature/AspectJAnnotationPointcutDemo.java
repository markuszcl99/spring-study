package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.aspect.AspectJPointcutConfig;
import com.markus.spring.aop.feature.domain.EchoController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: markus
 * @date: 2022/11/5 1:26 PM
 * @Description: AspectJ Pointcut 指令表达式不同使用方式使用 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAspectJAutoProxy
public class AspectJAnnotationPointcutDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotationPointcutDemo.class, AspectJPointcutConfig.class);
        context.refresh();

        EchoService echoService = context.getBean(EchoService.class);
        echoService.echo("Hello World");

        System.out.println("-----------------------------");

        EchoController echoController = context.getBean(EchoController.class);
        echoController.echo(echoService);

        System.out.println("-----------------------------");
        echoController.echo();

        context.close();
    }

    @Bean
    public EchoService echoService() {
        EchoService echoService = new DefaultEchoService();
        return echoService;
    }

    @Bean
    public EchoController echoController() {
        EchoController echoController = new EchoController();
        return echoController;
    }
}
