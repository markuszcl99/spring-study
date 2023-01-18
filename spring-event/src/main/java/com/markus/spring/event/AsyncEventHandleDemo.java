package com.markus.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.AbstractApplicationEventMulticaster;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.context.support.AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME;

/**
 * @author: markus
 * @date: 2023/1/17 10:32 PM
 * @Description: 同步切换异步 事件处理
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AsyncEventHandleDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.addApplicationListener(new ApplicationListener<MySpringEvent>() {
            @Override
            public void onApplicationEvent(MySpringEvent event) {
                System.out.printf("[线程 : %s] 事件 : %s", Thread.currentThread(), event.getSource());
            }
        });

        // 1. 容器刷新阶段
        context.refresh();

        // 2. 获取事件广播器
        ApplicationEventMulticaster applicationEventMulticaster =
                context.getBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);

        if (applicationEventMulticaster instanceof SimpleApplicationEventMulticaster) {
            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = (SimpleApplicationEventMulticaster) applicationEventMulticaster;
            ExecutorService executorService = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("my-spring-event-publisher-pool-"));
            simpleApplicationEventMulticaster.setTaskExecutor(executorService);

            applicationEventMulticaster.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
                @Override
                public void onApplicationEvent(ContextClosedEvent event) {
                    if (!executorService.isShutdown()) {
                        executorService.shutdown();
                    }
                }
            });
        }

        // 3. 发布事件
        context.publishEvent(new MySpringEvent("Hello World!"));

        // 4. 容器关闭
        context.close();
    }
}
