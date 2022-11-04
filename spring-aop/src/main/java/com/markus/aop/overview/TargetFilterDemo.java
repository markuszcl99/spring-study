package com.markus.aop.overview;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/11/4 10:50 PM
 * @Description: Aop 目标过滤示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class TargetFilterDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String targetClassName = "com.markus.aop.overview.EchoService";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> targetClass = classLoader.loadClass(targetClassName);
        // 查找方法
        Method method = ReflectionUtils.findMethod(targetClass, "echo", String.class);
        System.out.println(method);
        // 查找异常类型
        ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                System.out.println("仅抛出异常为NullPointException的方法为: " + method);
            }
        }, new ReflectionUtils.MethodFilter() {
            @Override
            public boolean matches(Method method) {
                return method.getParameterCount() == 1
                        && method.getParameterTypes()[0] == String.class
                        && method.getExceptionTypes().length == 1
                        && method.getExceptionTypes()[0] == NullPointerException.class;
            }
        });
    }
}
