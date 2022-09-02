package com.markus.spring.spring.dependency.injectionv2;

import com.markus.spring.spring.dependency.injection.UserHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/8/29 10:38 PM
 * @Description: xml方式 setter方法注入 示例
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class XmlDependencySetterInjectionDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-setter-injection.xml");

        UserHolder userHolder = context.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}
