package com.markus.spring.aop.feature;

import com.markus.aop.overview.EchoService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/11/5 12:35 PM
 * {@link ProxyFactoryBean}
 * @Description: ProxyFactoryBean 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ProxyFactoryBeanDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-proxy-factory-bean.xml");
        context.refresh();

        EchoService echoService = context.getBean("proxyFactoryBean",EchoService.class);
        echoService.echo("Hello World!");

        context.close();
    }
}
