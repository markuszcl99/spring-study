package com.markus.spring.aop.feature;

import com.markus.aop.overview.EchoService;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/11/5 10:36 PM
 * @Description: AOP 自动代理示例
 * {@link BeanNameAutoProxyCreator}
 * {@link DefaultAdvisorAutoProxyCreator}
 * {@link AnnotationAwareAspectJAutoProxyCreator}
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AspectJAutoProxyDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-auto-proxy-context.xml");

        EchoService echoService = context.getBean(EchoService.class);
        echoService.echo("Hello World!");

        context.close();
    }
}
