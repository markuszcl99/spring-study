package com.markus.spring.aop.feature.blog;

import com.markus.spring.aop.feature.blog.aspect.AspectJPointcutExpressionConfig;
import com.markus.spring.aop.feature.blog.domain.ArgsDemo;
import com.markus.spring.aop.feature.blog.domain.DefaultPointcutDemo;
import com.markus.spring.aop.feature.blog.domain.PointcutDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: markus
 * @date: 2022/12/1 10:24 PM
 * @Description: 横切点表达式使用示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAspectJAutoProxy
public class AspectJPointcutExpressionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJPointcutExpressionDemo.class, AspectJPointcutExpressionConfig.class);
        context.refresh();

        PointcutDemo pointcutDemo = context.getBean(PointcutDemo.class);
        ArgsDemo argsDemo = context.getBean(ArgsDemo.class);
        System.out.println("-----start-----");
        pointcutDemo.specialReferenceDemo(argsDemo);
        System.out.println("-----end-----");
        context.close();
    }

    @Bean
    public PointcutDemo pointcutDemo() {
        return new DefaultPointcutDemo();
    }

    @Bean
    public ArgsDemo argsDemo() {
        return new ArgsDemo("Hello World!");
    }
}
