package com.markus.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * @author: markus
 * @date: 2023/2/5 11:07 PM
 * @Description: 自定义@Autowired派生注解
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Autowired
public @interface MyAutowired {
}
