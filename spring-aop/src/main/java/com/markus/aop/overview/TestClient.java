package com.markus.aop.overview;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/10/9 4:30 PM
 * @Description: 容器执行
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class TestClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/aop-application-context.xml");

        TestBeanAOP bean = context.getBean("testBeanAOP", TestBeanAOP.class);
        bean.test();

        context.close();
    }
}
