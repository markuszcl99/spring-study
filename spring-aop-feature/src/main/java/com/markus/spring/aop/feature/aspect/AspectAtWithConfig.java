package com.markus.spring.aop.feature.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: markus
 * @date: 2022/11/28 11:48 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AspectAtWithConfig {
    @Pointcut("@within(com.markus.aop.overview.annotation.EchoInterface)")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {

    }
}
