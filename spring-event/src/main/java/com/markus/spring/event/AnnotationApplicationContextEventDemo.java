package com.markus.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author: markus
 * @date: 2023/1/12 11:10 PM
 * @Description: 注解驱动的ApplicationContext事件演示示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@EnableAsync
public class AnnotationApplicationContextEventDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationApplicationContextEventDemo.class);

        context.refresh();
        context.start();
        context.stop();
        context.close();

    }

    @EventListener
    @Order(1)
    public void onStartEventListener1(ContextStartedEvent contextStartedEvent) {
        printable("ContextStartedEvent1");
    }

    @EventListener
    @Order(2)
    public void onStartEventListener2(ContextStartedEvent contextStartedEvent) {
        printable("ContextStartedEvent2");
    }

    @EventListener
    @Async
    public void onAsyncStartEventListener(ContextStartedEvent contextStartedEvent) {
        printable("ContextStartedEvent");
    }

    @EventListener
    public void onContextStoppedEvent(ContextStoppedEvent contextStoppedEvent) {
        printable("ContextStoppedEvent");
    }

    @EventListener
    public void onContextRefreshedEvent(ContextRefreshedEvent contextRefreshedEvent) {
        printable("ContextRefreshedEvent");
    }

    @EventListener
    public void onContextClosedEvent(ContextClosedEvent contextClosedEvent) {
        printable("ContextClosedEvent");
    }

    public static void printable(Object printable) {
        System.out.printf("[ 线程: %s] : %s\n", Thread.currentThread().getName(), printable);
    }
}
