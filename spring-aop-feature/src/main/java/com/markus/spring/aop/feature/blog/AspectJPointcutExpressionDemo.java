package com.markus.spring.aop.feature.blog;

import com.markus.spring.aop.feature.blog.advisor.DefaultStaticMethodMatcherPointcut;
import com.markus.spring.aop.feature.blog.aspect.AspectJPointcutExpressionConfig;
import com.markus.spring.aop.feature.blog.domain.ArgsDemo;
import com.markus.spring.aop.feature.blog.domain.DefaultPointcutDemo;
import com.markus.spring.aop.feature.blog.domain.PointcutDemo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Method;

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

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(new DefaultStaticMethodMatcherPointcut(), new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("this is custom code advisor!");
            }
        });
        return defaultPointcutAdvisor;
    }
}
