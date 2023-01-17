package com.markus.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: markus
 * @date: 2023/1/17 10:33 PM
 * @Description: 自定义事件
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MySpringEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MySpringEvent(Object source) {
        super(source);
    }
}
