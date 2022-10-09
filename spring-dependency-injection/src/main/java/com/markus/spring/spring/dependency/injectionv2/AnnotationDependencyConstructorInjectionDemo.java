package com.markus.spring.spring.dependency.injectionv2;

import com.markus.spring.ioc.container.domain.User;
import com.markus.spring.spring.dependency.injection.UserHolder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author: markus
 * @date: 2022/9/4 11:28 AM
 * @Description: 注解驱动 构造器注入 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AnnotationDependencyConstructorInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencySetterInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(context);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml");

        context.refresh();

        UserHolder userHolder = context.getBean(UserHolder.class);
        System.out.println(userHolder);

        context.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        // 构造器注入
        UserHolder userHolder = new UserHolder(user);
        return userHolder;
    }
}