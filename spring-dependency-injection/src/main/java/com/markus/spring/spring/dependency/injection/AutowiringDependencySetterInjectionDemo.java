package com.markus.spring.spring.dependency.injection;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/20 10:25 上午
 * @Description: 自动绑定 setter依赖注入 示例
 * @Blog: http://markuszhang.com/
 */
public class AutowiringDependencySetterInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 加载Bean定义
        String resourcePath = "classpath:/META-INF/autowiring-dependency-setter-injection.xml";
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions(resourcePath);

        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder.getUser());

        applicationContext.close();

    }
}
