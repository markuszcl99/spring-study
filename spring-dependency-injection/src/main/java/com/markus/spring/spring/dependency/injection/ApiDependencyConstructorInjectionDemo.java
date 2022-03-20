package com.markus.spring.spring.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/20 10:49 上午
 * @Description: Spring API 实现构造器注入 示例
 * @Blog: http://markuszhang.com/
 */
public class ApiDependencyConstructorInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 加载 User的BeanDefinition
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String resourcePath = "classpath:/META-INF/dependency-lookup.xml";
        reader.loadBeanDefinitions(resourcePath);

        // 创建UserHolder 的BeanDefinition
        BeanDefinition beanDefinition = createBeanDefinition();
        applicationContext.registerBeanDefinition("userHolder",beanDefinition);

        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder.getUser());

        // 关闭应用上下文
        applicationContext.close();
    }

    private static BeanDefinition createBeanDefinition(){
        BeanDefinitionBuilder builder  =  BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
//        builder.addConstructorArgReference("user"); // 通过名称查找
        builder.addConstructorArgReference("superUser");
        return builder.getBeanDefinition();
    }
}
