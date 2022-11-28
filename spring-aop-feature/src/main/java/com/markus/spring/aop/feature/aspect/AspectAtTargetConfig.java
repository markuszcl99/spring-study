package com.markus.spring.aop.feature.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: markus
 * @date: 2022/11/28 11:44 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Aspect
public class AspectAtTargetConfig {
    @Pointcut("@target(com.markus.aop.overview.annotation.EchoInterface)")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {

    }
}
