package com.markus.spring.spring.dependency.injectionv2;

import com.markus.spring.spring.dependency.injection.UserHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/9/2 10:07 PM
 * @Description: 构造器 依赖注入
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class XmlDependencyConstructorInjectionDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-constructor-injection.xml");

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();
    }
}
