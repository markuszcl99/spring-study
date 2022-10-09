package com.markus.aop;

import org.aspectj.lang.JoinPoint;
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

    @Pointcut(value = "execution(* *.test(..))")
    public void test() {

    }

    /**
     * 切入点执行之前执行
     */
    @Before(value = "test()")
    public void before() {
        System.out.println("@Before");
    }

    /**
     * 切入点执行之后执行
     */
    @After(value = "test()")
    public void after() {
        System.out.println("@After");
    }

    @AfterReturning(value = "test()")
    public void afterReturning() {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing(value = "test()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        System.out.println("@AfterThrowing " + e.getMessage());
    }

    /**
     * 切入点环绕执行
     * 1. 切入点执行前
     * 2. 切入点执行后
     * 3. 切入点异常后
     *
     * @param point
     * @return
     */
    @Around(value = "test()")
    public Object around(ProceedingJoinPoint point) {
        System.out.println("【Around】before");
        Object o = null;
        try {
            o = point.proceed();
            System.out.println("【Around】after");
        } catch (Throwable e) {
            // 因为这里有异常捕捉，所以@AfterThrowing注解不生效
            System.out.println("【Around】exception");
//            e.printStackTrace();
        } finally {
            System.out.println("【Around】finally");
        }
        return o;
    }
}
