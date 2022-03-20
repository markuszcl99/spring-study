package com.markus.spring.spring.dependency.injection;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/20 10:36 上午
 * @Description: xml 实现构造器注入 示例
 * @Blog: http://markuszhang.com/
 */
public class XmlDependencyConstructorInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 加载xml 资源获取BeanDefinition
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String resourcePath = "classpath:/META-INF/dependency-constructor-injection.xml";
        reader.loadBeanDefinitions(resourcePath);

        // 启动上下文
        applicationContext.refresh();
        // 依赖查找
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder.getUser());

        // 关闭上下文
        applicationContext.close();
    }
}
