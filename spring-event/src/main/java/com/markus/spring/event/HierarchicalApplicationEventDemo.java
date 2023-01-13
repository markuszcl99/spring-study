package com.markus.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author: markus
 * @date: 2023/1/13 11:20 PM
 * @Description: 事件层次性传播
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class HierarchicalApplicationEventDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.setId("parent-context");
        parentContext.register(HierarchicalApplicationEventDemo.class, MyListener.class);


        AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();
        currentContext.setId("current-context");
        currentContext.register(HierarchicalApplicationEventDemo.class, MyListener.class);

        // 父子容器建立关联
        currentContext.setParent(parentContext);

        parentContext.refresh();
        currentContext.refresh();

        parentContext.close();
        currentContext.close();
    }

    static class MyListener implements ApplicationListener<ApplicationContextEvent> {

        @Override
        public void onApplicationEvent(ApplicationContextEvent event) {
            System.out.printf("[容器: %s]- event: %s\n", event.getApplicationContext().getId(), event.getClass().getSimpleName());
        }
    }
}
