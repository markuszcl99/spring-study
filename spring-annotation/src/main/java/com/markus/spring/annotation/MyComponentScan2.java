package com.markus.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * {@link Component} Scan 注解
 *
 * @see ComponentScan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@MyComponentScan
public @interface MyComponentScan2 {

    /**
     * 与 @MyComponentScan属性同名 为显示重写
     * @return
     */
    String[] scanBasePackages() default {};

    /**
     * 隐性重写
     * @return
     */
    @AliasFor("scanBasePackages")
    String[] packages() default {};
}
