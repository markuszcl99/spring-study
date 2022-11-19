package com.markus.spring.aop.feature.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author: markus
 * @date: 2022/11/19 10:19 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class StaticExecutor implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public void execute() {
        System.out.println("Execute...");
        applicationEventPublisher.publishEvent(new ExecutedEvent(this));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
