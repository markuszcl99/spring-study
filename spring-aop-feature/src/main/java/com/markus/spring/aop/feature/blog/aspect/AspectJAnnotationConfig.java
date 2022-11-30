package com.markus.spring.aop.feature.blog.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author: markus
 * @date: 2022/11/29 1:16 PM
 * @Description: 前置方法拦截
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Aspect
public class AspectJAnnotationConfig {
    @Before(value = "target(com.markus.aop.overview.EchoService)")
    public void before() {
        System.out.println("这是前置通知");
    }

    @After(value = "target(com.markus.aop.overview.EchoService)")
    public void after() {
        System.out.println("这是方法最终通知");
    }

    @AfterReturning(value = "target(com.markus.aop.overview.EchoService)")
    public void afterReturning() {
        System.out.println("这是方法返回通知");
    }

    @AfterThrowing(value = "target(com.markus.aop.overview.EchoService)")
    public void afterThrowing() {
        System.out.println("这是方法异常通知");
    }

    @Around(value = "target(com.markus.aop.overview.EchoService)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是方法环绕前置通知");
        try {
            Object obj = pjp.proceed();
            System.out.println("这是方法环绕返回通知");
            return obj;
        } catch (Throwable e) {
            System.out.println("这是方法环绕异常通知");
            throw e;
        } finally {
            System.out.println("这是方法环绕最终通知");
        }
    }

}
