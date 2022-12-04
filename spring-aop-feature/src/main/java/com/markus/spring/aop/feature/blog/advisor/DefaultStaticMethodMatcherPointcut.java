package com.markus.spring.aop.feature.blog.advisor;

import com.markus.spring.aop.feature.blog.domain.ArgsDemo;
import com.markus.spring.aop.feature.blog.domain.DefaultPointcutDemo;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/12/4 12:06 PM
 * @Description: 静态方法匹配链接点
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DefaultStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return DefaultPointcutDemo.class.equals(targetClass)
                && method.getParameterCount() == 1
                && method.getParameterTypes()[0].equals(ArgsDemo.class);
    }
}
