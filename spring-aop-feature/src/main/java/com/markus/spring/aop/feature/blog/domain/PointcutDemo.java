package com.markus.spring.aop.feature.blog.domain;

import com.markus.aop.overview.annotation.EchoInterface;

/**
 * @author: markus
 * @date: 2022/12/1 10:17 PM
 * @Description: 横切点表达式演示示例接口
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface PointcutDemo {
    public void commonDemo(String message);

    public void specialDemo(String message);

    public void specialReferenceDemo(ArgsDemo argsDemo);
}
