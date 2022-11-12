package com.markus.spring.aop.feature;

import com.markus.aop.overview.AopService;
import com.markus.aop.overview.DefaultAopService;
import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.aspect.AspectJDeclareParentConfig;
import com.markus.spring.aop.feature.introduction.UsageTracked;
import com.markus.spring.aop.feature.introduction.support.DefaultUsageTracked;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: markus
 * @date: 2022/11/12 10:22 PM
 * @Description: @DeclareParents 切面增强
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAspectJAutoProxy
public class AspectJDeclareParentsAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AspectJDeclareParentsAnnotationDemo.class, AspectJDeclareParentConfig.class);
        applicationContext.refresh();
        EchoService echoService = applicationContext.getBean(EchoService.class);
        UsageTracked usageTracked = (UsageTracked) echoService;
        usageTracked.echoMethodInvokeCount();// print 1
        echoService.echo("Hello World!"); // print 2 and [echo] Hello World

        AopService aopService = applicationContext.getBean(AopService.class);
        aopService.hello();

        //加上AopService之后，容器中的UsageTracked实例就变为两个了：EchoService、AopService
//        UsageTracked usageTracked = applicationContext.getBean("echoService", UsageTracked.class);
//        System.out.println("echoService == usageTracked : " + (echoService == usageTracked));

    }

    @Bean
    public EchoService echoService() {
        return new DefaultEchoService();
    }

    @Bean
    public AopService aopService() {
        return new DefaultAopService();
    }
}
