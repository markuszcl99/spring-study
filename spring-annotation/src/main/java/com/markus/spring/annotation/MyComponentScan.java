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
@ComponentScan
public @interface MyComponentScan {
    @AliasFor(value = "value", annotation = ComponentScan.class) // 隐式别名
    String[] scanBasePackages() default {"#"};

    @AliasFor(value = "basePackages", annotation = ComponentScan.class) // 显示别名
    String[] scanBasePackagesExplicitAliases() default {"#"};
}
