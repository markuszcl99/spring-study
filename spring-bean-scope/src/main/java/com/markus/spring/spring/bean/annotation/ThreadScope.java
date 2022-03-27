package com.markus.spring.spring.bean.annotation;

import com.markus.spring.spring.bean.scope.ThreadLocalScope;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

/**
 * @author: markus
 * @date: 2022/3/27 8:58 下午
 * @Description: 自定义Scope注解
 * @Blog: http://markuszhang.com/
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope(ThreadLocalScope.SCOPE_NAME)
public @interface ThreadScope {
}
