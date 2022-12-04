package com.markus.spring.aop.feature.blog;

import com.markus.spring.aop.feature.blog.aspect.AspectJDeclareParentsConfig;
import com.markus.spring.aop.feature.blog.domain.DefaultPointcutDemo;
import com.markus.spring.aop.feature.blog.domain.PointcutDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: markus
 * @date: 2022/12/4 7:03 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAspectJAutoProxy
public class AspectJDeclareParentsDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJDeclareParentsDemo.class, AspectJDeclareParentsConfig.class);
        context.refresh();

        PointcutDemo pointcutDemo = context.getBean(PointcutDemo.class);
        pointcutDemo.commonDemo("Hello World!");

        context.close();
    }

    @Bean
    public PointcutDemo pointcutDemo() {
        return new DefaultPointcutDemo();
    }
}
