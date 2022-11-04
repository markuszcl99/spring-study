package com.markus.spring.aop.feature;

import com.markus.aop.overview.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/11/4 11:08 PM
 * @Description: AspectJ xml实现
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AspectJXmlDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-applicationContext.xml");

        EchoService echoService = context.getBean(EchoService.class);
        echoService.echo("Hello World");

        context.close();
    }
}
