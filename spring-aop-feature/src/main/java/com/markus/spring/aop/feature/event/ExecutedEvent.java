package com.markus.spring.aop.feature.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: markus
 * @date: 2022/11/19 10:21 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ExecutedEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ExecutedEvent(Object source) {
        super(source);
    }
}
