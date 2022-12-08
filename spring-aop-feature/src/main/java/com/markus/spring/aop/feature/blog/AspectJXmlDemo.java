package com.markus.spring.aop.feature.blog;

import com.markus.aop.overview.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/12/4 10:11 PM
 * @Description: 基于Xml的aop拦截示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AspectJXmlDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-advice-application-context.xml");
        EchoService echoService = context.getBean(EchoService.class);
        echoService.echo("Hello World!");
        context.close();
    }
}
