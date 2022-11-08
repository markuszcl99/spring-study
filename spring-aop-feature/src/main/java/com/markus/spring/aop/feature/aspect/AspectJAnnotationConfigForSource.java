package com.markus.spring.aop.feature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author: markus
 * @date: 2022/11/7 11:07 PM
 * @Description: 源码调试使用
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Aspect
public class AspectJAnnotationConfigForSource {

    @Pointcut("this(com.markus.aop.overview.EchoService)")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("@Before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("@After");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing("pointcut()")
    public void throwsAdvice() {
        System.out.println("@AfterThrowing");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before");
        Object result = pjp.proceed();
        System.out.println("around after");
        return result;
    }
}
