package com.markus.spring.aop.feature.pointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/5 3:51 PM
 * @Description: EchoSerivce 连接点 实现
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class EchoServicePointcut extends StaticMethodMatcherPointcut {

    private String methodName;
    private Class<?> targetClass;

    public EchoServicePointcut(String methodName, Class<?> targetClass) {
        Assert.notNull(methodName, "methodName must be not null");
        Assert.notNull(targetClass, "targetClass must be not null");
        this.methodName = methodName;
        this.targetClass = targetClass;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return methodName.equals(method.getName())
                && this.targetClass.isAssignableFrom(targetClass);
    }
}
