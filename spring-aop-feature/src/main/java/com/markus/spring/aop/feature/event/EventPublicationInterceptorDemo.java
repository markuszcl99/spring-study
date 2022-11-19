package com.markus.spring.aop.feature.event;

import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.EventPublicationInterceptor;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/19 10:17 PM
 * @Description: Spring AOP在事件中的应用示例
 * {@link EventPublicationInterceptor}
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Configuration
@EnableAspectJAutoProxy
public class EventPublicationInterceptorDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EventPublicationInterceptorDemo.class, Executor.class, StaticExecutor.class);
        context.refresh();

        Executor executor = context.getBean(Executor.class);
        executor.execute();

        StaticExecutor staticExecutor = context.getBean(StaticExecutor.class);
        staticExecutor.execute();

        context.close();
    }

    // 1. 将EventPublicationInterceptor 声明为Spring Bean
    @Bean
    public EventPublicationInterceptor eventPublicationInterceptor() {
        EventPublicationInterceptor eventPublicationInterceptor = new EventPublicationInterceptor();
        eventPublicationInterceptor.setApplicationEventClass(ExecutedEvent.class);
        return eventPublicationInterceptor;
    }

    @Bean
    public Pointcut pointcut() {
        return new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return "execute".equals(method.getName()) && Executor.class.equals(targetClass);
            }
        };
    }

    @Bean
    public PointcutAdvisor pointcutAdvisor(Pointcut pointcut, EventPublicationInterceptor eventPublicationInterceptor) {
        return new DefaultPointcutAdvisor(pointcut, eventPublicationInterceptor);
    }

    @EventListener
    public void execute(ExecutedEvent event) {
        System.out.println("Execute : " + event);
    }
}
