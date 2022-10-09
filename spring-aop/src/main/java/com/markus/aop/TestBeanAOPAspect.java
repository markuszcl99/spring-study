package com.markus.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author: markus
 * @date: 2022/10/9 4:14 PM
 * @Description: 切面
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Aspect
public class TestBeanAOPAspect {

    @Pointcut("execution(* *.test(..))")
    public void test() {

    }

    /**
     * 切入点执行之前执行
     */
    @Before("test()")
    public void before() {
        System.out.println("before invoke test method!");
    }

    /**
     * 切入点执行之后执行
     */
    @After("test()")
    public void after() {
        System.out.println("after invoke test method!");
    }

    /**
     * 切入点环绕执行
     *  1. 切入点执行前
     *  2. 切入点执行后
     *  3. 切入点异常后
     *
     * @param point
     * @return
     */
    @Around("test()")
    public Object around(ProceedingJoinPoint point) {
        System.out.println("before");
        Object o = null;
        try {
            o = point.proceed();
        } catch (Throwable e) {
            System.out.println("exception");
//            e.printStackTrace();
        }
        System.out.println("after");
        return o;
    }

}
