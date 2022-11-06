package com.markus.spring.aop.feature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * @author: markus
 * @date: 2022/11/4 11:46 PM
 * @Description: AspectJ 注解 配置
 * 使用案例可以参考spring官方文档：https://docs.spring.io/spring-framework/docs/5.2.19.RELEASE/spring-framework-reference/core.html#aop-advice
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
//    @Pointcut(value = "execution(public * *(..))")
    @Pointcut(value = "within(com.markus.aop.overview.*)")
    public void pointcut() {

    }

    @Before(value = "pointcut() && args(message)", argNames = "message")
    public void before(String message) {
        System.out.println(message);/*就是为了调试信息看，可能用处不大，至少以现在掌握的知识来看是*/
        System.out.println("@Before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("@After");
    }

    @AfterReturning(
            value = "pointcut()",
            returning = "retVal"
    )
    public void afterWithRetValue(Object retVal) {
        System.out.printf("@AfterReturning its retValue is %s\n", retVal);
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
