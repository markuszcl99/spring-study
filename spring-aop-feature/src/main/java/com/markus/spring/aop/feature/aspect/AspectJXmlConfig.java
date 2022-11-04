package com.markus.spring.aop.feature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author: markus
 * @date: 2022/11/4 11:26 PM
 * @Description: 切面，用于xml使用
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AspectJXmlConfig {
    public void pointcut() {
    }

    public void before() {
        System.out.println("AspectJXmlConfig#before");
    }

    public void after() {
        System.out.println("AspectJXmlConfig#after");
    }

    public void afterReturn() {
        System.out.println("AspectJXmlConfig#afterReturn");
    }

    public void throwException() {
        System.out.println("AspectJXmlConfig#throwException");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("------around before------");
        Object result = pjp.proceed();
        System.out.println("------around after------");
        return result;
    }

}
