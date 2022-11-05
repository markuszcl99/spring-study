package com.markus.aop.overview.annotation;

import java.lang.annotation.*;

/**
 * 自定义枚举
 */
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EchoInterface {
}
