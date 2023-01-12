package com.markus.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author: markus
 * @date: 2023/1/12 11:05 PM
 * @Description: application事件演示
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ApplicationContextEventDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("Spring onApplicationEvent " + event);
            }
        });

        context.refresh();
        context.start();
        context.stop();
        context.close();
    }
}
