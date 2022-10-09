package com.markus.aop;

/**
 * @author: markus
 * @date: 2022/10/9 4:09 PM
 * @Description: AOP示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class TestBeanAOP {
    public void test() {
        System.out.println("【target method】AOP Hello World!");
        int i = 1 / 0;
    }
}
