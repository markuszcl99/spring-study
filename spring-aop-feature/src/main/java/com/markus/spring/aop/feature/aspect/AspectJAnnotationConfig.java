package com.markus.spring.aop.feature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * @author: markus
 * @date: 2022/11/4 11:46 PM
 * @Description: AspectJ 注解 配置
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Configuration
@Aspect
public class AspectJAnnotationConfig {

    /**
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
     * modifiers-pattern 方法访问类型(可选)
     * ret-type-pattern 方法返回类型(必填)
     * declaring-type-pattern 方法的声明类(可选)
     * name-pattern 方发的签名(必填)
     * param-pattern 方法的参数类型(必填，空表示无参数)
     * throws-pattern 方法抛出的异常类型(可选)
     */
    @Pointcut(value = "execution(public * *(..))")
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
    public void afterReturn() {
        System.out.println("@AfterReturning");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("@Around before");
        Object result = pjp.proceed();
        System.out.println("@Around after");
        return result;
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("@AfterThrowing");
    }
}
